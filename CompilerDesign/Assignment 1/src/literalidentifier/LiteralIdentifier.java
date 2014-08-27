/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package literalidentifier;

import java.io.*;
import java.util.*;

/**
 *
 * @author mayankmittal
 */
@SuppressWarnings({"FieldMayBeFinal","UnusedAssignment"})
public class LiteralIdentifier {
    private static boolean res,d,valid,chckForFloat;
    private static int counter, begin, end;
    private static int[] delimiters = {37,38,42,43,44,45,47,59,60,61,62,91,93,124};
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    @SuppressWarnings({"CallToPrintStackTrace","MismatchedReadAndWriteOfArray"})
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        PrintStream fileStream = new PrintStream(new File("literalTable.txt"));
        
        try ( Scanner s = new Scanner(new BufferedReader(new FileReader("C:\\hello\\hello.c"))) ) {
            while(s.hasNext()){
                String str = s.next();
                //System.out.println(str);
                char[] myChar = str.toCharArray();
                res = false; d = false; valid = false; chckForFloat = false; counter = 0;
                
                for(int i=0; i<str.length(); i=++counter){
                    int x = myChar[i];
                    
                    if(x==46){
                        d = true;
                        chckFloat(myChar,i,d);
                    }
                    else if(x==48)
                        chckOcta(myChar,i);
                    else if(x>48 && x<58)
                        chckConst(myChar,i);
                    else if(x==39)
                        chckChar(myChar,i);
                    
                    if(res){
                        String validLiteral = "";
                        int length=(end-begin+1);
                        for(int j=0; j<length; j++)
                            validLiteral += myChar[begin+j];
                        System.out.println(validLiteral);
                        fileStream.println(validLiteral);
                        res = false; d = false; valid = false; chckForFloat = false;
                    }
                }
            }
            s.close();
        }
    }
    
    // Check For Character
    private static void chckChar(char[] myChar, int i) {
        boolean quote_can_happ = false;
        int alt = 0;
        begin = i+1;
        while(true){
            int x = 0;
            x = getNextX(myChar, i, x);
            if(valid){
                res = false;
                i++;
            }
            else if(x==1000){
                res = false;
                delimitize(myChar,i);
                break;
            }
            else if(x==92){
                alt = (++alt)%2;
                i++;
            }
            else if(x==39){
                if(alt==1){
                    delimitize(myChar,i);
                    break;
                }
                if(quote_can_happ){
                    end = i;
                    res = true;
                    counter = i+1;
                    break;
                }
            }
            else{
                quote_can_happ = true;
                alt = 0;
                i++;
            }
        }
    }
    
    // Check For Constant Numbers
    private static void chckConst(char[] myChar, int i) {
        boolean u_happ=false, l_happ=false, doPostChecking=true;
        chckForFloat=false;
        begin = i;
        //pre-checking
        int z = 0;
        try {
            z = myChar[i-1];
        } catch(Exception ex) {}
        if( (z>64 && z<91) || (z>96 && z<123) || (z==95) ){
            doPostChecking = false;
            delimitize(myChar,i);
        }
        //post-checking
        if(doPostChecking){
            int l_limit = 47,u_limit = 58;
            postChecking(myChar, i, l_limit, u_limit, l_happ, u_happ, false);
        }
        if(chckForFloat)
            chckFloat(myChar,begin,d);
    }
    
    // Checking For OctaDecimal Numbers
    private static void chckOcta(char[] myChar, int i) {
        boolean u_happ = false, l_happ = false, doPostChecking = true, chckForHexa = false;
        chckForFloat = false;
        begin = i;
        int x = 0;
        x = getNextX(myChar, i, x);
        if(x==1000 || valid)
            doPostChecking = false;
        else if(x==88 || x==120){
            doPostChecking = false;
            chckForHexa = true;
        }
        if(doPostChecking){
            int l_limit = 47,u_limit = 56;
            postChecking(myChar, i, l_limit, u_limit, l_happ, u_happ, true);
        }
        if(chckForFloat)
            chckFloat(myChar,begin,d);
        else if(chckForHexa)
            chckHexa(myChar, begin);
    }
    
    // Checking For Float Numbers
    private static void chckFloat(char[] myChar, int i, boolean d) {
        boolean decimal_happ=d, e_happ=false, e_can_happ=false, suffix_happ=false;
        begin = i;
        while(true){
            int x = 0;
            x = getNextX(myChar, i, x);
            if(x==1000 || valid)
                break;
            else if(x>47 && x<58 && !suffix_happ){
                e_can_happ = true;
                i++;
            }
            else if(x==46 && !e_happ && !suffix_happ && !decimal_happ){
                decimal_happ = true;
                i++;
            }
            else if((x==69 || x==101) && (e_can_happ || !d) && !suffix_happ && !e_happ){
                int y=0, z=0;
                try {
                    y = myChar[i+2];
                } catch(Exception ex) {
                    delimitize(myChar,i);
                    break;
                }
                if(y==43 || y==45){
                    try {
                        z = myChar[i+3];
                    } catch(Exception ex) {
                        delimitize(myChar,i);
                        break;
                    }
                    if(z>47 && z<58){
                        i+=2;
                    }
                    else{
                        delimitize(myChar,i);
                        break;
                    }
                }
                else if(y>47 && y<58){
                    i++;
                }
                e_happ = true;
                i++;
            }
            else if( (x==70 || x==102 || x==76 || x==108) && !suffix_happ){
                suffix_happ = true;
                i++;
            }
            else{
                delimitize(myChar,i);
                break;
            }
        }
    }
    
    // Checking For HexaDecimal Numbers
    private static void chckHexa(char[] myChar, int i) {
        boolean u_happ = false, l_happ = false, lookFurthur = true, modeswitched = false;
        begin = i; i++;
        int l_limit = 47, u_limit = 58;
        int low_limit = 64, up_limit = 71;
        int lower_limit = 96, upper_limit = 103;
        int x = 0;
        x = getNextX(myChar, i, x);
        if(x==1000 || valid){
            res = false;
            lookFurthur = false;
        }
        else if(xLiesInNormalLimits(l_limit, u_limit, x, l_happ, u_happ))
            i++;
        else if(xLiesInNormalLimits(low_limit, up_limit, x, l_happ, u_happ))
            i++;
        else if(xLiesInNormalLimits(lower_limit, upper_limit, x, l_happ, u_happ))
            i++;
        else
            lookFurthur = false;
        
        if(lookFurthur){
            while(true){
                x = getNextX(myChar, i, x);
                if(x==1000 || valid)
                    break;
                else if(xLiesInNormalLimits(l_limit, u_limit, x, l_happ, u_happ))
                    i++;
                else if(xLiesInNormalLimits(low_limit, up_limit, x, l_happ, u_happ))
                    i++;
                else if(xLiesInNormalLimits(lower_limit, upper_limit, x, l_happ, u_happ))
                    i++;
                else if((x==76 || x==108) && !l_happ){
                    l_happ = true;
                    i++;
                }
                else if((x==85 || x==117) && !u_happ){
                    u_happ = true;
                    i++;
                }
                else if(x==46){
                    i++;
                    modeswitched = true;
                    break;
                }
                else{
                    delimitize(myChar,i);
                    break;
                }
            }
            if(modeswitched){
                boolean can_halt = false, ap_occ = false;
                while(true){
                    int z = 0;
                    z = getNextX(myChar, i, z);
                    if(z==1000 || valid){
                        if(!can_halt){
                            res = false;
                            delimitize(myChar,i);
                            break;
                        }
                        else
                            break;
                    }
                    else if(z>47 && z<58){
                        if(ap_occ)
                            can_halt = true;
                        i++;
                    }
                    else if(z==65 || z==97){
                        int y = 0;
                        y = getNextX(myChar, i+1, y);
                        if(y==1000 || valid){
                            res = false;
                            delimitize(myChar,i);
                            break;
                        }
                        else if(y==80 || y==112){
                            ap_occ = true;
                            i++;
                        }
                        else{
                            delimitize(myChar,i);
                            break;
                        }
                        i++;
                    }
                    else{
                        delimitize(myChar,i);
                        break;
                    }
                }
            }
        }
    }
    
    // Post-Checking
    private static void postChecking(char[] myChar, int i, int l_limit, int u_limit, boolean l_happ, boolean u_happ, boolean oct) {
        boolean chckd = false;
        while(true){
            int x = 0;
            x = getNextX(myChar, i, x);
            if(x==1000 || valid)
                break;
            else if(xLiesInNormalLimits(l_limit, u_limit, x, l_happ, u_happ))
                i++;
            else if((x==76 || x==108) && !l_happ){
                l_happ = true;
                i++;
            }
            else if((x==85 || x==117) && !u_happ){
                u_happ = true;
                i++;
            }
            else if( (x==46 || x==69 || x==101) && !u_happ && !l_happ){
                chckForFloat = true;
                break;
            }
            else if((x==56 || x==57) && oct && !chckd){
                chckd = true;
                int j = i, y = 0;
                while(true){
                    int z = 0;
                    z = getNextX(myChar, j, z);
                    if(z==1000 || valid){
                        y = 1;
                        res = false;
                        delimitize(myChar,i);
                        break;
                    }
                    else if(z==46){
                        y = 1;
                        chckForFloat = true;
                        break;
                    }
                    else{
                        j++;
                    }
                }
                if(y==1)
                    break;
            }
            else{
                delimitize(myChar,i);
                break;
            }
        }
    }
    
    // Check if x Lies In Normal Limits
    private static boolean xLiesInNormalLimits(int l_limit, int u_limit, int x,boolean l_happ, boolean u_happ) {
        if(x>l_limit && x<u_limit){
            if(!u_happ && !l_happ)
                return true;
        }
        return false;
    }
    
    // Check Delimiter
    private static int getNextX(char[] myChar, int i, int x) {
        try {
            x = myChar[i+1];
        } catch(Exception ex) {
            x = 1000;
            end = i;
            res = true;
            counter = i;
        }
        for(int j=0; j<14; j++){
            if(x==delimiters[j]){
                valid = true;
                break;
            }
        }
        if(valid){
            end = i;
            res = true;
            counter = i;
        }
        return x;
    }
    
    // Delmitize a character stream
    private static void delimitize(char[] myChar, int i) {
        boolean doBreak=false;
        while(true){
            int x = 0;
            try {
                x = myChar[i+1];
            } catch(Exception ex) {
                counter = i;
                break;
            }
            for(int j=0; j<14; j++){
                if(x==delimiters[j]){
                    counter = i;
                    doBreak = true;
                    break;
                }
            }
            if(doBreak)
                break;
            else
                i++;
        }
    }
    
}