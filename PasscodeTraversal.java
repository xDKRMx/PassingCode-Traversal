// Passcodde Traversal Method
class Solution {
    static String printMinNumberForPattern(String S) {
        String[] result = new String[S.length() +1];
        int index = 0;
        int key = 0;
        int ele_kept = 0;
        int inc = 0;
        int element = 0;
        for(int i = 0; i < S.length() +1; i++) {
            String passcode = "";
            if(i == 0) passcode = "0" +"-" + S.charAt(i);
            else if (i == S.length()) passcode = S.charAt(i -1) +"-" + "0";
            else 
            {
                passcode = S.charAt(i -1) + "-"+ S.charAt(i);
            }
            
            switch (passcode) {
                case "0-I":
                    result[index++] = "1";
                    key = 1;
                    break;
                case "0-D":
                    ele_kept++;
                    break;
                case "I-I":
                inc++;
                ele_kept++;
                    break;
                case "I-D":
                    if(inc>0 && ele_kept > 0)
                    {
                        element = key + 1;
                        
                        for(int j = inc; j > 0 ; j--) {
                            
                            
                            result[index++] =Integer.toString(element);
                            element++;  
                        }
                        inc = 0;
                        key = element -1;
                        ele_kept = 0;
                    }
                    ele_kept++;
                    break;
                case "D-D":
                ele_kept++;
                    break;
                case "D-I":
                    ele_kept++;
                    key += ele_kept;
                    element = key;
                    for(int j = 1; j <= ele_kept; j++) {

                        result[index++] =Integer.toString(element);
                        element--;
                    }
                    ele_kept = 0;
                    break;
                case "I-0":
                    if(inc > 0 && ele_kept > 0) 
                    {
                        element = key + 1;
                        for(int j = inc; j > 0 ; j--) {
                            
                            result[index++] =Integer.toString(element);
                            element++;
                        }
                        inc = 0;
                        key = element -1;
                        ele_kept = 0;
                    }
                    result[index++] =Integer.toString((key+1));
                    break;

                case "D-0":
                    ele_kept++;
                    key += ele_kept;
                    element = key;
                    for(int j = 1; j <= ele_kept; j++) {

                        result[index++] =Integer.toString(element);
                        element--;
                    }
                    ele_kept = 0;
                    break;
            
           }
        }
        String result_nums = "";
        for(int i = 0; i < result.length; i++) {
           result_nums += result[i];
        }
        return result_nums;
    }
    
}