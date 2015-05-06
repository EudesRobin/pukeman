package Interface;

import java.io.*;
import pacman.EnumDifficulte;
import pacman.Global;

/**
 * Methodes de récupération, écriture et lecture dans un fichier du score le
 * plus haut
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Highscore {
	// Source :
	// http://www.caveofprogramming.com/frontpage/articles/java/java-file-reading-and-writing-files-in-java/

	String fileName1 = "highscore.txt";
	String line1;
	String line2;
	String line3;

	public Highscore() {
		try {
			FileReader fileReader = new FileReader(fileName1);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line1 = bufferedReader.readLine();
			line2 = bufferedReader.readLine();
			line3 = bufferedReader.readLine();
			Global.hseasy = Integer.valueOf(line1);
			Global.hsmedium = Integer.valueOf(line2);
			Global.hshard = Integer.valueOf(line3);
			//System.out.println("Highscore Facile : " + Global.hseasy);
			//System.out.println("Highscore Moyen : " + Global.hsmedium);
			//System.out.println("Highscore Difficile : " + Global.hshard);
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}

	}

	public void newhs() {
		try {
			if (EnumDifficulte.diff == "Facile") {
				if (Global.scorecoop > Global.hseasy) {
					FileWriter fileWriter = new FileWriter(fileName1);
					BufferedWriter bufferedWriter = new BufferedWriter(
							fileWriter);

					line1 = String.valueOf(Global.scorecoop);
					Global.hseasy = Global.scorecoop;

					bufferedWriter.write(line1);
					bufferedWriter.newLine();
					bufferedWriter.write(line2);
					bufferedWriter.newLine();
					bufferedWriter.write(line3);
					bufferedWriter.close();
				}
			} else if (EnumDifficulte.diff == "Moyen") {
				if (Global.scorecoop > Global.hsmedium) {
					FileWriter fileWriter = new FileWriter(fileName1);
					BufferedWriter bufferedWriter = new BufferedWriter(
							fileWriter);

					line2 = String.valueOf(Global.scorecoop);
					Global.hsmedium = Global.scorecoop;

					bufferedWriter.write(line1);
					bufferedWriter.newLine();
					bufferedWriter.write(line2);
					bufferedWriter.newLine();
					bufferedWriter.write(line3);
					bufferedWriter.close();
				}
			}

			else if (EnumDifficulte.diff == "Difficile") {
				if (Global.scorecoop > Global.hshard) {
					FileWriter fileWriter = new FileWriter(fileName1);

					BufferedWriter bufferedWriter = new BufferedWriter(
							fileWriter);

					line3 = String.valueOf(Global.scorecoop);
					Global.hshard = Global.scorecoop;

					bufferedWriter.write(line1);
					bufferedWriter.newLine();
					bufferedWriter.write(line2);
					bufferedWriter.newLine();
					bufferedWriter.write(line3);
					bufferedWriter.close();
				}
			}
		} catch (FileNotFoundException ex) {

		} catch (IOException ex) {

		}
	}
}
