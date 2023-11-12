//import okhttp3.*;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.ResponseBody;
//
//import java.io.IOException;
//
//
//public class APITest {
//
//    int remainingCards;
//    boolean shuffled;
//    private String deckID;
//
//    // Constructor method
//    public APITest(String deckID, int remainingCards, Boolean shuffled) {
//        this.deckID = deckID;
//        this.remainingCards = remainingCards;
//        this.shuffled = shuffled;
//    }
//
//    public static void main(String[] args) throws IOException {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1")
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//
//            ResponseBody responseBody = response.body();
//
//            // Converting responseBody into a string
//            if (responseBody != null) {
//                String responseBodyString = responseBody.string();
//                String[] newString = responseBodyString.split(",");
//                // Storing values from responseBody and adding and creating an example class as a test
//                String deckID = newString[1].split(":")[1].trim();
//                int remainingCards = Integer.parseInt(newString[2].split(":")[1].trim());
//                String tempShuffled = newString[3].split(":")[1].trim();
//                Boolean shuffled = Boolean.parseBoolean(tempShuffled.replace("}", ""));
//                APITest temp = new APITest(deckID, remainingCards, shuffled);
//                // Printing out values to check if properly added
//                System.out.println(temp.deckID);
//                System.out.println(temp.remainingCards);
//                System.out.println(temp.shuffled);
//                }
//
//            // Check if everything was successful
//            int statusCode = response.code();
//            if (statusCode == 200) {
//                System.out.println("Success!");
//            } else {
//                System.out.print("Failed");
//            }
//
//        } catch (IOException e) {
//            throw new IOException(e);
//        }
//    }
//}
