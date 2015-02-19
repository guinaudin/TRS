import java.util.List;
import model.ArchiveHeader;
import model.AutomationFile;
import model.TextFileReader;

public class TRS {
    public static void main(String[] args) {  
        //creation d'une tache(Runnable) contenant le code d�di� � la cr�ation de la fen�tre et on l'ajoute dans le thread de Swing
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {   
                //Instanciation de notre modèle
                //AbstractModel abstractModel = new Game();
                //Création du contrôleur
                //AbstractControler controler = new BoardControler(abstractModel);
                //Création de notre fenêtre avec le contrôleur en paramètre
                //MainView boardView = new MainView(controler);
            }
        });*/
        AutomationFile AH = new AutomationFile(TextFileReader.getResource("AH.txt"));
        List<ArchiveHeader> archiveHeaderList = AH.getArchiveHeaderList();
        
        System.out.println(archiveHeaderList.size());
        
        for(int i = 0; i < archiveHeaderList.size(); i++) {
            System.out.println("AH " + i + "\nAH_TIMESTAMP1 : " + archiveHeaderList.get(i).getAH_TIMESTAMP1());
            System.out.println("AH_TIMESTAMP2 : " + archiveHeaderList.get(i).getAH_TIMESTAMP2());
            System.out.println("AH_TIMESTAMP3 : " + archiveHeaderList.get(i).getAH_TIMESTAMP3());
            System.out.println("AH_TIMESTAMP4 : " + archiveHeaderList.get(i).getAH_TIMESTAMP4() + "\n");
        }
    }
}
