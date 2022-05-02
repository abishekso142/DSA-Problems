

public class StringExercises
{

    public static void main(String[] args)
    {
       /** String res = "hello";
                
        String cookieValue = "__VCAP_ID__=4cdbe56a-2ca7-40ab-4396-bfb1; Path=/; HttpOnly; Secure";
        if(cookieValue.contains("__VCAP_ID__")) {
           // cookieValue.replace("__VCAP_ID__", "__SDM_VCAP_ID__");
            
           res =  cookieValue.replace("__VCAP_ID__", "__SDM_VCAP_ID__");
        }
        System.out.println(res); */
        
        
        
        String cookie = "JSESSIONID=E6FF3067D194DB359B3E69D8CD848C3D;__SDM_VCAP_ID__=4cdbe56a-2ca7-40ab-4396-bfb1;__VCAP_ID__=e7b0bf5c-db7f-4dd0-77a7-f3fb;";
        String[] arr = cookie.split(";");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i].contains("__VCAP_ID__")) {
                continue;
            }
            if(arr[i].contains("__SDM_VCAP_ID__")) {
                arr[i] = arr[i].replace("__SDM_VCAP_ID__","__VCAP_ID__");
            }
            str.append(arr[i] + ";");
            
        }
        
        System.out.println(str.toString());

    }

}
