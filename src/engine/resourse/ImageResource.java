package engine.resourse;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import engine.rendering.Renderer;

public class ImageResource  {
    private Texture texture = null;

    private BufferedImage image = null;   

    public ImageResource(String path){
        
        // generate the relatice path
        URL url = ImageResource.class.getResource(path); // TODO: change the url building

        // load the image from the file
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Apperently this fixes a potencial memory leak
        if(image != null){
            image.flush();
        }
    }

    public Texture getTexture(){
        if(image == null) return null;

        if(texture == null){
            texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);
        }
        
        return texture;
    }
}