package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.paint.Color;
/*
 * A class that loads and saves game settings from a file on the computer.
 */
public class Settings {
	//the player who starts, takes the value 1 or 2.
	public int starter;
	public javafx.scene.paint.Color p1c;
	public javafx.scene.paint.Color p2c;
	public int width;
	public int height;
	private File filename;
	/*
	 * Constructor, sets the filename.
	 * Actuall values will be loaded from the file.
	 */
	public Settings(String s) {
		this.filename = new File(s);
		if (!this.filename.exists()) {
			this.setDefaults();
		}
	}
	public void load() {
        BufferedReader in;
        String[] split;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            this.starter = Integer.parseInt(in.readLine());
            split = in.readLine().split(" ");
            p1c = Color.color((double)(((float)Integer.parseInt(split[0])) / 255.0), 
            		(double)(((float)Integer.parseInt(split[1])) / 255.0),
            		(double)(((float)Integer.parseInt(split[2])) / 255.0));
            split = in.readLine().split(" ");
            p2c = Color.color((double)(((float)Integer.parseInt(split[0])) / 255.0), 
            		(double)(((float)Integer.parseInt(split[1])) / 255.0),
            		(double)(((float)Integer.parseInt(split[2])) / 255.0));
            this.width = Integer.parseInt(in.readLine());
            this.height = Integer.parseInt(in.readLine());
            in.close();
        } catch (IOException e) {
            System.out.println("IO exception.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception.");
            e.printStackTrace();
        }
    }
    /**
     * Save table data to the specified file.
     * @param filename - the name of the file to be loaded.
     */
    public void save() {
        FileOutputStream out;
        try {
            out = new FileOutputStream(filename);
            String output = "";
            output = starter + "\n" + (int)(this.p1c.getRed() * 255.0) + " " + (int)(this.p1c.getGreen() * 255.0) + " "
            + (int)(this.p1c.getBlue() * 255.0) + "\n" + (int)(this.p2c.getRed() * 255.0) + " " + (int)(this.p2c.getGreen() * 255.0)
            + " " + (int)(this.p2c.getBlue() * 255.0) + "\n" + this.width + "\n" + this.height;
            out.write(output.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * If no file is found, a new file is made with default values.
     * note, these aren't 'magic numbers', they're just the default values.
     */
    public void setDefaults() {
    	starter = 2;
    	p1c = Color.WHITE;
    	p2c = Color.BLACK;
    	width = 8;
    	height = 8;
		save();
    }
}
