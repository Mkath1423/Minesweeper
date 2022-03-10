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

    private static Map<URL, BufferedImage> images = new HashMap<URL, BufferedImage>();

    private static URL generateURl(String path){
        // generate the relative path
        return ImageResource.class.getResource(path); // TODO: change the url building 
    }

    public static void loadImage(String path, boolean hasMultipleSprites){
        
        URL url = generateURl(path);

        // load the image from the file
        try {
            if(!images.containsKey(url)){
                images.put(url, ImageIO.read(url)); 
                images.get(url).flush(); // Apperently this fixes a potencial memory leak
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Texture getTexture(String path){
        URL url = generateURl(path);

        // return null if the image has not been loaded
        if(!images.containsKey(url)) return null;
        if(images.get(url) == null) return null;
        
        // generate the texture if needed and return it
        if(!textures.containsKey(url)){
            textures.put(url, AWTTextureIO.newTexture(Renderer.getProfile(), images.get(url), true));
        }
        
        return textures.get(url);
    }
}