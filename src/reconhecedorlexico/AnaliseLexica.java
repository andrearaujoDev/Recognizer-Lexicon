package reconhecedorlexico;

public class AnaliseLexica {
    private String s;
    private int i;
    
    public AnaliseLexica(String s){
        this.s = s;
        this.i = 0;
    }
    
    public char cabecote(){
        if((i < s.length()) && (s.length() > 0)){
            return s.charAt(i);
        }else{
            return '?';
        }
    }
    
    public Boolean analisador(){
        char c;
        c = cabecote();
        i++;
        
        //Reconhecendo as letras
        
        if(Character.isLetter(c)){
            while((Character.isLetter(c) || Character.isDigit(c) || c == '_') && (i<= s.length())){
                c = cabecote();
                i++;
            }
            if(i > s.length()){
                return true;
            }else{
                return false;
            }
        }
        //Reconhecendo Strings 
        else if(c == '\''){
            while(i <= s.length() -1){
                c = cabecote();
                i++;
            }
            
            if(c == '\''){
                return true;
            }else{
                return false;
            }
   
        }
        //Reconhecendo comentarios de multiplas linhas
        else if(c == '{'){
            while(i <= s.length() -1){
                c = cabecote();
                i++;
            }
                        
            if(c == '}'){
                return true;
            }else{
                return false;
            }
        }
        //Reconhecendo comentarios de uma linha
        else if(c == '/'){
            c = cabecote();
            i++;
            
            if(c == '/'){
                while(i <= s.length() -1){
                    c = cabecote();
                    i++;
                }
                return true;
            }else{
                return false;
            }
        }
        //Reconhecendo zeros positivos(Ex : 0 ; 0.999)
        else if(c == '0'){
            if(s.length() == 1){
                return true;
            }else{
                c = cabecote();
                i++;
                if(c == '.'){
                    c = cabecote();
                    i++;
                    if(Character.isDigit(c)){
                        while(Character.isDigit(c) && (i <= s.length() -1)){
                            c = cabecote();
                            i++;
                        }
                        if(c == '.'){
                            return false;
                        }
                        return true;
                    }else{
                        return false;
                    }
                }
               return false;
            }
        }
        //Reconhecendo inteiros positivos e reais positivos (Ex : 123 ; 123.321)
        else if(Character.isDigit(c) && c != '0'){
            while((Character.isDigit(c)) && (!Character.isLetter(c)) && (i <= s.length())){
                c = cabecote();
                i++;
                /* if(Character.isLetter(c)){
                   return false;
                */
            }
            if(i > s.length() ){
                return true;
            }else{
                if(c == '.'){
                    c = cabecote();
                    i++;
                    if(Character.isDigit(c)){
                        while((Character.isDigit(c)) && (!Character.isLetter(c)) && (i <= s.length())){
                            c = cabecote();
                            i++;
                        }
                        
                        if(i > s.length()){
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        //Reconhecendo inteiros negativos e reais negativos (Ex : -123 ; -123.321 || -0 ; -0.250)
        else if(c == '-'){
            c = cabecote();
            i++;
            if(Character.isDigit(c) && c != '0'){
                while((Character.isDigit(c)) && (!Character.isLetter(c)) && (i <= s.length())){
                    c = cabecote();
                    i++;
                    /* if(Character.isLetter(c)){
                       return false;
                    */
                }
                if(i > s.length() ){
                    return true;
                }else{
                    if(c == '.'){
                        c = cabecote();
                        i++;
                        if(Character.isDigit(c)){
                            while((Character.isDigit(c)) && (!Character.isLetter(c)) && (i <= s.length())){
                                c = cabecote();
                                i++;
                            }

                            if(i > s.length()){
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
            }else if(c == '0'){
                c = cabecote();
                i++;
                if(c == '.'){
                        c = cabecote();
                        i++;
                        if(Character.isDigit(c)){
                            while((Character.isDigit(c)) && (!Character.isLetter(c)) && (i <= s.length())){
                                c = cabecote();
                                i++;
                            }

                            if(i > s.length()){
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
            }else{
                return false;
            }
        }
        else{
            return false;
        }  
    }
}