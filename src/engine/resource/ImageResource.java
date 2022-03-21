package engine.resource;

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

    /**
     * Generates an absolute path to a specified file
     * 
     * @param path the path to the image relative to /resource 
     * @return the url to that path
     */
    private static URL generateURl(String path){
        // generate the relative path
        return ImageResource.class.getResource(path); // TODO: change the url building 
    }

    /**
     * Loads the image file
     * 
     * Loads the image file into a texture object
     * 
     * Generates a SpriteMap and stores in the textures map
     * 
     * SpriteMap will have 1 sprite in it
     * 
     * @param path the path to the image relative to /resource 
     */
    public static void loadImage(String path){
        URL url = generateURl(path);

        BufferedImage image;

        // load the image from the file
        try {
            image = ImageIO.read(url); 
            image.flush(); // Apparently this fixes a potential memory leak
            
            // generate the texture
            Texture texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, false);

            // construct the spritemap object and store it
            textures.put(url, new SpriteMap(texture, url));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("loaded texture " + url.toString() );
    }

    /**
     * Loads the image file
     * 
     * Loads the image file into a texture object
     * 
     * Generates a SpriteMap and stores in the textures map
     * 
     * SpriteMap will have cellsWide*cellsTall sprites in it
     * 
     * @param path the path to the image relative to /resource 
     * @param cellsWide the number of cells in the x direction
     * @param cellsTall the number of cells in the y direction
     */
    public static void loadImage(String path, float cellsWide, float cellsTall){
        URL url = generateURl(path);

        BufferedImage image;
        // load the image from the file
        try {
            image = ImageIO.read(url); 
            image.flush(); // Apparently this fixes a potential memory leak

            // generate the texture
            Texture texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);

            // construct the spritemap object and store it
            textures.put(url, new SpriteMap(texture, url, cellsWide, cellsTall));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets and return the SpriteMap for a URL
     * 
     * @param path the path to the image relative to /resource 
     * @return the SpriteMap object
     */
    public static SpriteMap getSpriteMap(String path){
        URL url = generateURl(path);
        
        // return the texture if it exists
        if(textures.containsKey(url)){
            return textures.get(url);
        }
        
        return null;
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