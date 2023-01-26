public class Lister {
    String connectedString = "";
    void connectString(String[] stringList){
        for (int i = 0; i < stringList.length; i++){
            connectedString += stringList[i];
        }
    }
}
