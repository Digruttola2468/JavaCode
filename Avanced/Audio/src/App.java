import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;


public class App {

    public static void main(String[] args) throws UnsupportedAudioFileException , IOException , LineUnavailableException{


        Scanner scanner = new Scanner(System.in);

        String NameFileMusicWAV = "src/example.wav";

        File file = new File(NameFileMusicWAV);             //Archivo de musica escuchar

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);                     //Abrimos el archivo 
        

        String response = "";

        while(!response.equals("Q")){
            System.out.println("P = play , S = stop , R = reset , Q = exit");
            System.out.print("Enter your choise: ");

            response = scanner.next();
            response = response.toUpperCase();      //Converimos la eleccion de la entrada de datos en mayuscula

            switch(response){
                case ("P"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case ("R"):
                    clip.setMicrosecondPosition(0);
                    break;
                case ("Q"):
                    clip.close();
                    break;
                default:
                    System.out.println("Not a valid response");
            }
        }

        System.out.println("Have a nice day");
        
    }


}
