package PEX2;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrew
 */
public class Enigma {

    private char[] alphabetList = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    public Enigma() {
        Scanner userIn = new Scanner(System.in);
        String cipherType = JOptionPane.showInputDialog("Encode(e) or Decode(d)?", null).toUpperCase();
        String codeType = JOptionPane.showInputDialog("Ceaser(c), General Substitution(gs), or Rotating(r)?", null).toUpperCase();
        String cipherTemp = JOptionPane.showInputDialog("Enter Text: ", null).toUpperCase();
        char[] cipher = cipherTemp.toCharArray();
        String keyTemp = JOptionPane.showInputDialog("Enter Cipher Key(0 if non-applicable): ", null).toUpperCase();  
        char[] key = keyTemp.toCharArray();
        startEncryption(cipherType, cipher, key, codeType);
    }
    
    public void startEncryption(String cipherType, char[] cipher, char[] cipherKey, String codeType) {
        ArrayList<Character> alphabet = new ArrayList<>();
        ArrayList<Character> encoded = new ArrayList<>();
        ArrayList<Character> key = new ArrayList<>();
        for(char c : cipherKey) {
            key.add(c);
        }
        for(char c : alphabetList) {
            alphabet.add(c);
        }
        switch (codeType) {
            case "C": {
                if (cipherType.equals("E")) {
                    for(char c: cipher) {
                        if(alphabet.contains(c))  {
                        int pos = alphabet.indexOf(c);
                        if(pos <24) {
                            pos += 3;
                            encoded.add(alphabet.get(pos));
                        }
                        else {
                            pos -= 23;
                        encoded.add(alphabet.get(pos));
                        }
                    }
                        else {
                            encoded.add(c);
                        }
                    }
                }
                if (cipherType.equals("D")) {
                    for(char c: cipher) {
                        if(alphabet.contains(c))  {
                        int pos = alphabet.indexOf(c);
                        if(pos >2) {
                            pos -= 3;
                            encoded.add(alphabet.get(pos));
                        }
                        else {
                            pos += 23;
                        encoded.add(alphabet.get(pos));
                        }
                    }
                        else {
                            encoded.add(c);
                        }
                    }
                }
                break;
            }
                
            
            
            case "GS":
            {
                if (cipherType.equals("E")) {
                    for(char c: cipher) {
                        if(key.contains(c))  {
                            
                        int pos = alphabet.indexOf(c);
                        encoded.add(key.get(pos)); 
                            
                        }
                        else {
                            encoded.add(c);
                        }
                    }
                }
                if (cipherType.equals("D")) {
                    for(char c: cipher) {
                        if(key.contains(c))  {
                            
                        int pos = key.indexOf(c);
                        encoded.add(alphabet.get(pos)); 
                            
                        }
                        else {
                            encoded.add(c);
                        }
                    }
                }
                break;
            }
                
            case "R":
            {
                if (cipherType.equals("E")) {
                    for(char c: cipher) {
                        if(key.contains(c))  {
                            
                        int pos = alphabet.indexOf(c);
                        encoded.add(key.get(pos)); 
                        char keyRotate = key.get(0);
                        key.remove(key.get(0));
                        key.add(24, keyRotate);
                            
                        }
                        else {
                            encoded.add(c);
                        }
                    }
                }
                if (cipherType.equals("E")) {
                    for(char c: cipher) {
                        if(key.contains(c))  {
                        int pos = key.indexOf(c);
                        encoded.add(alphabet.get(pos)); 
                        char keyRotate = key.get(0);
                        key.remove(key.get(0));
                        key.add(024, keyRotate);
                            
                        }
                        else {
                            encoded.add(c);
                        }
                    }
                }
                break;
            }
            default: 
                JOptionPane.showMessageDialog(null, ("ERROR, one or more questions were answered incorrectly!"));  
        }
        String result;
        StringBuilder builder = new StringBuilder();
        for(char c : encoded) {
            builder.append(c);
        }
        result = builder.toString();
        JOptionPane.showMessageDialog(null, ("Result is " + result));
    }
    
}

