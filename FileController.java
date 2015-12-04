import java.io.*;

public class FileController {
    private String path;
    public FileController(String path) {
        this.path = path;
        try{
            File file = new File(path);
            if(file.exists()){
                System.out.println("Il file " + path + " esiste già");
            }
            else if(!file.exists()){
                file.createNewFile();
                System.out.println("Il file " + path + " e' stato creato");
            }
            else{
                System.out.println("Il file " + path + " non può essere creato");
            }
        }
        catch(IOException e){
            System.out.println("Error: \n" + e.getMessage());
        }
        
    }
    
    public void delete(){
        try{
        File file = new File(path);
        if(file.exists()){
            file.delete();
            System.out.println("Il file " + path + " è stato eliminato");
        }
        else{
            System.out.println("Il file " + path + " non esiste");
        }
        }
        catch(Exception e){
            System.out.println("Error: \n" + e.getMessage());
        }
    }
    
    public void append(String add){
        
        try{
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        if(file.exists()){
            fw.write("\n" + add);
            System.out.println("La stringa è stata aggiunta al file");
            fw.close();
            
        }
        }
        catch(IOException e){
            System.out.println("Error: \n" + e.getMessage());
        }
    }
    
        public void write(){
        
        try{
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        if(file.exists()){
            fw.write("");
            System.out.println("Il file è stato rigenerato");
            fw.close();
        }
        }
        catch(IOException e){
            System.out.println("Error: \n" + e.getMessage());
        }
    }
    
    public String read(){
        
        String readed = "";
        try{
        File file = new File(path);
        FileReader fr = new FileReader(file);
        char[] read = new char[200];
        if(file.exists()){
            fr.read(read);
            fr.close();
            readed = String.valueOf(read);
        }
        else{
            System.out.println("Il  file " + path + " non esiste.");
        }
        }
        catch(IOException e){
            System.out.println("Error: \n" + e.getMessage());
        }
        return readed;
    }
}
