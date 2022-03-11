package engine.resourse;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import engine.rendering.Renderer;

public class ImageResource  {
    private static Map<URL, SpriteMap> textures = new HashMap<URL, SpriteMap>();

    private static URL generateURl(String path){
        // generate the relative path
        return ImageResource.class.getResource(path); // TODO: change the url building 
    }

    public static void loadImage(String path){
        URL url = generateURl(path);

        BufferedImage image;
        // load the image from the file
        try {
            image = ImageIO.read(url); 
            image.flush(); // Apperently this fixes a potencial memory leak
            
            // generate the texture
            Texture texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, false);

            // construct the spritemap object and store it
            textures.put(url, new SpriteMap(texture));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadImage(String path, float cellsWide, float cellsTall){
        URL url = generateURl(path);

        BufferedImage image;
        // load the image from the file
        try {
            image = ImageIO.read(url); 
            image.flush(); // Apperently this fixes a potencial memory leak

            // generate the texture
            Texture texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);

            // construct the spritemap object and store it
            textures.put(url, new SpriteMap(texture, cellsWide, cellsTall));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Sprite getSprite(String path){
        URL url = generateURl(path);
        
        // return the texture if it exists
        if(textures.containsKey(url)){
            return textures.get(url).getSprite();
        }

        return null;
    }

    public static Sprite getSprite(String path, int cell){
        URL url = generateURl(path);
        
        // return the texture if it exists
        if(textures.containsKey(url)){
            return textures.get(url).getSprite(cell);
        }

        return null;
    }
}