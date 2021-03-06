package splitting;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageSplitting  {

    private BufferedImage image;
    private int rows;
    private int cols;
    private int pieceWidth;
    private int pieceHeight;
    private ArrayList<BufferedImage> imagePieces = new ArrayList<BufferedImage>();
    private String savePath;

    public ImageSplitting(String pathImage, int rows, int cols, String savePath) {
        renderImage(pathImage);
        this.rows = rows;
        this.cols = cols;
        this.savePath = savePath;
        this.pieceWidth = image.getWidth() / cols;
        this.pieceHeight = image.getHeight() / rows;

        createImagePieces();
    }

    public void renderImage(String pathImage) {
        try {
            this.image = ImageIO.read(new File(pathImage));
        } catch (IOException e) {
            throw new IllegalArgumentException("이미지를 생성할 수 없습니다.");
        }
    }

    public void createImagePieces() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                imagePieces.add(createImagePiece(r, c));
            }
        }
    }

    private BufferedImage createImagePiece(int row, int col) {
        BufferedImage result = new BufferedImage(pieceWidth, pieceHeight, image.getType());
        for (int y = 0; y < pieceHeight; y++) {
            for (int x = 0; x < pieceWidth; x++) {
                result.setRGB(x, y, image.getRGB(x+col*pieceWidth, y+row*pieceHeight));
            }
        }
        return result;
    }

    public void saveImagePieces() {
        for (int i = 0; i < imagePieces.size(); i++) {
            saveImageFile(imagePieces.get(i), "Image_"+i);
        }
    }

    public void saveImageFile(BufferedImage image, String imageName) {
        try {
            File outfile = new File(savePath+"/saved_"+imageName+".png");
            ImageIO.write(image, "png", outfile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("이미지를 저장할 수 없습니다.");
        }
    }

}
