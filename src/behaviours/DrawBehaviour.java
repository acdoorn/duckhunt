//package behaviours;
//
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import models.Bird;
//import models.Unit;
//import views.UnitView;
//import controllers.GameController;
//
//public class DrawBehaviour implements Behaviour {
//	
//        private Image _gfx;
//
//        private int _frameCount;
//        private double _frameTime;
//        private boolean _loop;
//
//        private boolean _animationCompleted;
//        private int _currentFrame;
//        private double _timePassed;
//
//        public DrawBehaviour(Unit unit, double frameTime, double angle, boolean loop)
//        {
//            // Beginstate voor non-readonly variabelen
//            Reset();
//
//            // Readonly variabelen
//            _frameTime = frameTime;
//            _loop = loop;
//
//            // Graphics object aanmaken
//            System.out.println(unit.toString());
//            _gfx = loadImage("./src/images/"+unit.toString()+".png");
//        }
//        
//        private BufferedImage loadImage(String imagePath) {
//
//        	try {
//    			return ImageIO.read(new File(imagePath));
//    		} catch (IOException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    			return null;
//    		}
//        }
//
//        public void Draw(Unit unit, GameController game)
//        {
////            if (_loop || !_animationCompleted)
////            {
////                _timePassed += game.getDelta();
////
////                // Update sprites when needed. Even for low framerates
////                while (_timePassed > _frameTime)
////                {
////                    _timePassed -= _frameTime;
////
////                    if (_currentFrame == _frameCount)
////                    {
////                        if (_loop)
////                            _currentFrame = 0;
////                        else
////                            _animationCompleted = true;
////                    }
////                }
////            }
////            AffineTransform tx;
////            if (unit.getDeltax() < 0)
////            {
////            	// Flip the image vertically
////            	tx = AffineTransform.getScaleInstance(-1, 1);
////            	tx.translate(0, -_gfx.getHeight(null));
////            	AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
////            	_gfx = op.filter((BufferedImage) _gfx, null);
////            }
////            else {
////            	tx = AffineTransform.getScaleInstance(1, 1);
////            	tx.translate(0, -_gfx.getHeight(null));
////            	AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
////            	_gfx = op.filter((BufferedImage) _gfx, null);
////            	
////            }
//        	System.out.println("PRINTING BIRD SOMEWHERE");
//        	UnitView uv = new UnitView((Bird) unit);
//            game.getMainFrame().add(uv);
//            uv.updateUI();
//        }
//
//        public void Reset()
//        {
//            _animationCompleted = false;
//            _currentFrame = 0;
//            _timePassed = 0;
//        }
//
//		@Override
//		public void behave(double deltaTime) {
//			// TODO Auto-generated method stub
//			
//		}
//}
