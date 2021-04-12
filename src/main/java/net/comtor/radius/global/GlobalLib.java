package net.comtor.radius.global;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import net.comtor.util.connection.ComtorConnection;
import net.comtor.util.connection.ComtorConnections;
import net.comtor.util.connection.ComtorConnectionsXmlReader;
import org.xml.sax.SAXException;

/**
 *
 * @author juandiego@comtor.net
 * @since Feb 14, 2019
 */
public class GlobalLib {

    private static final Logger LOG = Logger.getLogger(GlobalLib.class.getName());

    public static String PROJECT_PATH;
    public static String NAME_CONNECTION;

    private ComtorConnection connection;
    private static GlobalLib instance;

    public static void setProjectParams(String projectPath, String nameConnection) {
        PROJECT_PATH = projectPath;
        NAME_CONNECTION = nameConnection;
    }

    @SuppressWarnings("UseSpecificCatch")
    private GlobalLib(String pathProject, String nameConnection) {
        try {
            ComtorConnections connections = ComtorConnectionsXmlReader.loadComtorConnections(pathProject);
            connection = connections.getComtorConnectionByName(nameConnection);
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            LOG.log(Level.SEVERE, NAME_CONNECTION, ex);
        }
    }

    private static GlobalLib getInstance(String pathProject, String nameConnection) {
        return ((instance == null) ? (instance = new GlobalLib(pathProject, nameConnection)) : instance);
    }

    public static GlobalLib getInstance() {
        return (instance == null) ? getInstance(PROJECT_PATH, NAME_CONNECTION) : instance;
    }

    public static void dispose() {
        instance = null;
    }

    public String getDatabaseDriver() {
        return connection.getDriver();
    }

    public String getDatabaseURL() {
        return connection.getUrl();
    }

    public String getDatabaseUser() {
        return connection.getUser();
    }

    public String getDatabasePassword() {
        return connection.getPassword();
    }
}
