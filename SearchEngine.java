
import java.io.IOException;
import java.net.URI;


class Handler implements URLHandler {
    // Create a string list for incoming strings
    String[] stringList = new String[100];
    //the index of a string
    int num = 0;
    // Initiate a string for concatenation
    String connectedString = "";

    // Concatenate strings
    String connectString(String string){
            connectedString = connectedString + string + String.format("\n");
        return connectedString;
    }

    //To pocess the incoming strings
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("The strings are %n %s", connectedString);
        }
        else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    connectedString = connectString(parameters[1]);
                    num++;
                    return String.format("The strings are: %n%s", connectedString);
                }
            }
            return "404 Not Found!";
        }

    }
}

// Run the web server
class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }

}

