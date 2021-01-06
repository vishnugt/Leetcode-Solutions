import java.util.HashMap;

class Logger {

    HashMap<String, Integer> keyVsMessage;
    
    public Logger() {
        keyVsMessage = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer previousTime = keyVsMessage.getOrDefault(message, -1);
        if(previousTime==-1 || timestamp - previousTime >= 10){
            keyVsMessage.put(message, timestamp);
            return true;
        }
        return false;
    }
}