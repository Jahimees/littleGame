package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private Image image;
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null){    
        	g.drawImage(image, 0, 0, null);
        }
    }
}