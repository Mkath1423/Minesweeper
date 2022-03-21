# Diff Details

Date : 2022-03-20 21:02:17

Directory d:\GitRepos\JOGL-Engine-2

Total : 111 files,  12 codes, 719 comments, 209 blanks, all 940 lines

[summary](results.md) / [details](details.md) / [diff summary](diff.md) / diff details

## Files
| filename | language | code | comment | blank | total |
| :--- | :--- | ---: | ---: | ---: | ---: |
| [README.md](/README.md) | Markdown | 6 | 0 | 2 | 8 |
| [src/engine/EventListener.java](/src/engine/EventListener.java) | Java | 42 | 2 | 21 | 65 |
| [src/engine/GameLoop.java](/src/engine/GameLoop.java) | Java | 7 | 0 | 2 | 9 |
| [src/engine/Inputs/KeyInput.java](/src/engine/Inputs/KeyInput.java) | Java | 30 | 25 | 16 | 71 |
| [src/engine/Inputs/KeyInputCaller.java](/src/engine/Inputs/KeyInputCaller.java) | Java | 13 | 6 | 6 | 25 |
| [src/engine/Inputs/KeyInputKeys.java](/src/engine/Inputs/KeyInputKeys.java) | Java | 47 | 13 | 11 | 71 |
| [src/engine/Inputs/MouseInput.java](/src/engine/Inputs/MouseInput.java) | Java | 31 | 24 | 13 | 68 |
| [src/engine/Inputs/MouseInputCaller.java](/src/engine/Inputs/MouseInputCaller.java) | Java | 37 | 24 | 13 | 74 |
| [src/engine/Inputs/MouseInputKeys.java](/src/engine/Inputs/MouseInputKeys.java) | Java | 11 | 0 | 2 | 13 |
| [src/engine/components/Event.java](/src/engine/components/Event.java) | Java | 21 | 24 | 7 | 52 |
| [src/engine/components/GameObject.java](/src/engine/components/GameObject.java) | Java | 8 | 17 | 8 | 33 |
| [src/engine/components/Image.java](/src/engine/components/Image.java) | Java | 64 | 64 | 24 | 152 |
| [src/engine/components/Transform.java](/src/engine/components/Transform.java) | Java | 82 | 46 | 25 | 153 |
| [src/engine/exeptions/DrawableNotInitialized.java](/src/engine/exeptions/DrawableNotInitialized.java) | Java | 6 | 0 | 2 | 8 |
| [src/engine/exeptions/LayerDoesNotExist.java](/src/engine/exeptions/LayerDoesNotExist.java) | Java | 6 | 0 | 2 | 8 |
| [src/engine/physics2D/collisions/Area.java](/src/engine/physics2D/collisions/Area.java) | Java | 46 | 35 | 9 | 90 |
| [src/engine/physics2D/collisions/Collisions.java](/src/engine/physics2D/collisions/Collisions.java) | Java | 18 | 25 | 5 | 48 |
| [src/engine/physics2D/collisions/Vector2.java](/src/engine/physics2D/collisions/Vector2.java) | Java | 9 | 7 | 3 | 19 |
| [src/engine/rendering/Drawable.java](/src/engine/rendering/Drawable.java) | Java | 10 | 46 | 10 | 66 |
| [src/engine/rendering/Drawer.java](/src/engine/rendering/Drawer.java) | Java | 79 | 69 | 51 | 199 |
| [src/engine/rendering/Layer.java](/src/engine/rendering/Layer.java) | Java | 39 | 33 | 15 | 87 |
| [src/engine/rendering/LayerKeys.java](/src/engine/rendering/LayerKeys.java) | Java | 8 | 0 | 2 | 10 |
| [src/engine/rendering/Renderer.java](/src/engine/rendering/Renderer.java) | Java | 45 | 15 | 16 | 76 |
| [src/engine/rendering/color/Color.java](/src/engine/rendering/color/Color.java) | Java | 27 | 33 | 10 | 70 |
| [src/engine/rendering/geometry/Point.java](/src/engine/rendering/geometry/Point.java) | Java | 20 | 26 | 7 | 53 |
| [src/engine/rendering/geometry/Quad.java](/src/engine/rendering/geometry/Quad.java) | Java | 52 | 55 | 17 | 124 |
| [src/engine/rendering/geometry/Triangle.java](/src/engine/rendering/geometry/Triangle.java) | Java | 20 | 19 | 8 | 47 |
| [src/engine/resourse/ImageResource.java](/src/engine/resourse/ImageResource.java) | Java | 62 | 10 | 27 | 99 |
| [src/engine/resourse/Sprite.java](/src/engine/resourse/Sprite.java) | Java | 27 | 0 | 11 | 38 |
| [src/engine/resourse/SpriteMap.java](/src/engine/resourse/SpriteMap.java) | Java | 42 | 0 | 20 | 62 |
| [src/engine/scenes/Scene.java](/src/engine/scenes/Scene.java) | Java | 42 | 0 | 12 | 54 |
| [src/engine/scenes/SceneManager.java](/src/engine/scenes/SceneManager.java) | Java | 29 | 0 | 12 | 41 |
| [src/engine/ui/elements/Text.java](/src/engine/ui/elements/Text.java) | Java | 31 | 6 | 15 | 52 |
| [src/engine/ui/elements/UIButton.java](/src/engine/ui/elements/UIButton.java) | Java | 63 | 38 | 24 | 125 |
| [src/engine/ui/elements/UIImage.java](/src/engine/ui/elements/UIImage.java) | Java | 3 | 0 | 3 | 6 |
| [src/engine/ui/layouts/Grid.java](/src/engine/ui/layouts/Grid.java) | Java | 3 | 0 | 3 | 6 |
| [src/minesweeper/Constants.java](/src/minesweeper/Constants.java) | Java | 28 | 4 | 8 | 40 |
| [src/minesweeper/Game.java](/src/minesweeper/Game.java) | Java | 95 | 22 | 31 | 148 |
| [src/minesweeper/gametypes/Tile.java](/src/minesweeper/gametypes/Tile.java) | Java | 90 | 27 | 28 | 145 |
| [src/minesweeper/scenetypes/GameScene.java](/src/minesweeper/scenetypes/GameScene.java) | Java | 152 | 41 | 51 | 244 |
| [d:\GitRepos\JOGL-Engine\README.md](/d:%5CGitRepos%5CJOGL-Engine%5CREADME.md) | Markdown | -6 | 0 | -2 | -8 |
| [d:\GitRepos\JOGL-Engine\bin\engine\EventListener.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CEventListener.class) | Java | -17 | 0 | 0 | -17 |
| [d:\GitRepos\JOGL-Engine\bin\engine\GameLoop.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CGameLoop.class) | Java | -5 | 0 | 0 | -5 |
| [d:\GitRepos\JOGL-Engine\bin\engine\Inputs\KeyInput.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CInputs%5CKeyInput.class) | Java | -19 | 0 | 0 | -19 |
| [d:\GitRepos\JOGL-Engine\bin\engine\Inputs\KeyInputCaller.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CInputs%5CKeyInputCaller.class) | Java | -14 | 0 | 0 | -14 |
| [d:\GitRepos\JOGL-Engine\bin\engine\Inputs\KeyInputKeys.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CInputs%5CKeyInputKeys.class) | Java | -27 | 0 | 0 | -27 |
| [d:\GitRepos\JOGL-Engine\bin\engine\Inputs\MouseInput.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CInputs%5CMouseInput.class) | Java | -18 | 0 | 0 | -18 |
| [d:\GitRepos\JOGL-Engine\bin\engine\Inputs\MouseInputCaller.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CInputs%5CMouseInputCaller.class) | Java | -27 | 0 | 0 | -27 |
| [d:\GitRepos\JOGL-Engine\bin\engine\Inputs\MouseInputKeys.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5CInputs%5CMouseInputKeys.class) | Java | -17 | 0 | 0 | -17 |
| [d:\GitRepos\JOGL-Engine\bin\engine\events\EventHandler.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cevents%5CEventHandler.class) | Java | -5 | 0 | 0 | -5 |
| [d:\GitRepos\JOGL-Engine\bin\engine\exeptions\DrawableNotInitialized.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cexeptions%5CDrawableNotInitialized.class) | Java | -6 | 0 | 0 | -6 |
| [d:\GitRepos\JOGL-Engine\bin\engine\exeptions\LayerDoesNotExist.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cexeptions%5CLayerDoesNotExist.class) | Java | -6 | 0 | 0 | -6 |
| [d:\GitRepos\JOGL-Engine\bin\engine\physics2D\collisions\Area.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cphysics2D%5Ccollisions%5CArea.class) | Java | -13 | 0 | 0 | -13 |
| [d:\GitRepos\JOGL-Engine\bin\engine\physics2D\collisions\Collisions.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cphysics2D%5Ccollisions%5CCollisions.class) | Java | -15 | 0 | 0 | -15 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\Drawable.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5CDrawable.class) | Java | -4 | 0 | -1 | -5 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\Drawer.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5CDrawer.class) | Java | -38 | 0 | 0 | -38 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\Layer.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5CLayer.class) | Java | -14 | 0 | 0 | -14 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\LayerKeys.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5CLayerKeys.class) | Java | -13 | 0 | 0 | -13 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\Renderer.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5CRenderer.class) | Java | -34 | 0 | 0 | -34 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\color\Color.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5Ccolor%5CColor.class) | Java | -14 | 0 | 0 | -14 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\geometry\Point.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5Cgeometry%5CPoint.class) | Java | -11 | 0 | 0 | -11 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\geometry\Quad.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5Cgeometry%5CQuad.class) | Java | -15 | 0 | 0 | -15 |
| [d:\GitRepos\JOGL-Engine\bin\engine\rendering\geometry\Triangle.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Crendering%5Cgeometry%5CTriangle.class) | Java | -13 | 0 | 0 | -13 |
| [d:\GitRepos\JOGL-Engine\bin\engine\resourse\ImageResource.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cresourse%5CImageResource.class) | Java | -30 | 0 | 0 | -30 |
| [d:\GitRepos\JOGL-Engine\bin\engine\resourse\Sprite.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cresourse%5CSprite.class) | Java | -7 | 0 | 0 | -7 |
| [d:\GitRepos\JOGL-Engine\bin\engine\resourse\SpriteMap.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cresourse%5CSpriteMap.class) | Java | -23 | 0 | 0 | -23 |
| [d:\GitRepos\JOGL-Engine\bin\engine\ui\elements\Button.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cui%5Celements%5CButton.class) | Java | -5 | 0 | 0 | -5 |
| [d:\GitRepos\JOGL-Engine\bin\engine\ui\elements\Image.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cui%5Celements%5CImage.class) | Java | -6 | 0 | 0 | -6 |
| [d:\GitRepos\JOGL-Engine\bin\engine\ui\elements\Text.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cui%5Celements%5CText.class) | Java | -5 | 0 | 0 | -5 |
| [d:\GitRepos\JOGL-Engine\bin\engine\ui\layouts\Grid.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cengine%5Cui%5Clayouts%5CGrid.class) | Java | -5 | 0 | 0 | -5 |
| [d:\GitRepos\JOGL-Engine\bin\minesweeper\Constants$kGame.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cminesweeper%5CConstants$kGame.class) | Java | -10 | 0 | 0 | -10 |
| [d:\GitRepos\JOGL-Engine\bin\minesweeper\Constants$kTile.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cminesweeper%5CConstants$kTile.class) | Java | -11 | 0 | 0 | -11 |
| [d:\GitRepos\JOGL-Engine\bin\minesweeper\Constants.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cminesweeper%5CConstants.class) | Java | -5 | 0 | 0 | -5 |
| [d:\GitRepos\JOGL-Engine\bin\minesweeper\Game.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cminesweeper%5CGame.class) | Java | -27 | 0 | -1 | -28 |
| [d:\GitRepos\JOGL-Engine\bin\minesweeper\Main.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cminesweeper%5CMain.class) | Java | -9 | 0 | 0 | -9 |
| [d:\GitRepos\JOGL-Engine\bin\minesweeper\gametypes\Tile.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cminesweeper%5Cgametypes%5CTile.class) | Java | -30 | 0 | 0 | -30 |
| [d:\GitRepos\JOGL-Engine\bin\minesweeper\util\GameUtils.class](/d:%5CGitRepos%5CJOGL-Engine%5Cbin%5Cminesweeper%5Cutil%5CGameUtils.class) | Java | -18 | 0 | 0 | -18 |
| [d:\GitRepos\JOGL-Engine\src\engine\EventListener.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CEventListener.java) | Java | -44 | -1 | -18 | -63 |
| [d:\GitRepos\JOGL-Engine\src\engine\GameLoop.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CGameLoop.java) | Java | -7 | 0 | -2 | -9 |
| [d:\GitRepos\JOGL-Engine\src\engine\Inputs\KeyInput.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CInputs%5CKeyInput.java) | Java | -32 | 0 | -13 | -45 |
| [d:\GitRepos\JOGL-Engine\src\engine\Inputs\KeyInputCaller.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CInputs%5CKeyInputCaller.java) | Java | -13 | -1 | -6 | -20 |
| [d:\GitRepos\JOGL-Engine\src\engine\Inputs\KeyInputKeys.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CInputs%5CKeyInputKeys.java) | Java | -48 | -1 | -10 | -59 |
| [d:\GitRepos\JOGL-Engine\src\engine\Inputs\MouseInput.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CInputs%5CMouseInput.java) | Java | -31 | 0 | -13 | -44 |
| [d:\GitRepos\JOGL-Engine\src\engine\Inputs\MouseInputCaller.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CInputs%5CMouseInputCaller.java) | Java | -37 | 0 | -12 | -49 |
| [d:\GitRepos\JOGL-Engine\src\engine\Inputs\MouseInputKeys.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5CInputs%5CMouseInputKeys.java) | Java | -11 | 0 | -2 | -13 |
| [d:\GitRepos\JOGL-Engine\src\engine\events\EventHandler.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cevents%5CEventHandler.java) | Java | -8 | 0 | -3 | -11 |
| [d:\GitRepos\JOGL-Engine\src\engine\exeptions\DrawableNotInitialized.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cexeptions%5CDrawableNotInitialized.java) | Java | -6 | 0 | -2 | -8 |
| [d:\GitRepos\JOGL-Engine\src\engine\exeptions\LayerDoesNotExist.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cexeptions%5CLayerDoesNotExist.java) | Java | -6 | 0 | -2 | -8 |
| [d:\GitRepos\JOGL-Engine\src\engine\physics2D\collisions\Area.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cphysics2D%5Ccollisions%5CArea.java) | Java | -46 | 0 | -6 | -52 |
| [d:\GitRepos\JOGL-Engine\src\engine\physics2D\collisions\Collisions.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cphysics2D%5Ccollisions%5CCollisions.java) | Java | -18 | 0 | -5 | -23 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\Drawable.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5CDrawable.java) | Java | -8 | -3 | -5 | -16 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\Drawer.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5CDrawer.java) | Java | -72 | -4 | -37 | -113 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\Layer.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5CLayer.java) | Java | -26 | -4 | -11 | -41 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\LayerKeys.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5CLayerKeys.java) | Java | -8 | 0 | -2 | -10 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\Renderer.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5CRenderer.java) | Java | -34 | 0 | -13 | -47 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\color\Color.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5Ccolor%5CColor.java) | Java | -27 | 0 | -8 | -35 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\geometry\Point.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5Cgeometry%5CPoint.java) | Java | -12 | 0 | -4 | -16 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\geometry\Quad.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5Cgeometry%5CQuad.java) | Java | -52 | 0 | -13 | -65 |
| [d:\GitRepos\JOGL-Engine\src\engine\rendering\geometry\Triangle.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Crendering%5Cgeometry%5CTriangle.java) | Java | -25 | -4 | -15 | -44 |
| [d:\GitRepos\JOGL-Engine\src\engine\resourse\ImageResource.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cresourse%5CImageResource.java) | Java | -54 | -9 | -22 | -85 |
| [d:\GitRepos\JOGL-Engine\src\engine\resourse\Sprite.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cresourse%5CSprite.java) | Java | -16 | 0 | -8 | -24 |
| [d:\GitRepos\JOGL-Engine\src\engine\resourse\SpriteMap.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cresourse%5CSpriteMap.java) | Java | -35 | 0 | -19 | -54 |
| [d:\GitRepos\JOGL-Engine\src\engine\ui\elements\Button.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cui%5Celements%5CButton.java) | Java | -3 | 0 | -3 | -6 |
| [d:\GitRepos\JOGL-Engine\src\engine\ui\elements\Image.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cui%5Celements%5CImage.java) | Java | -3 | 0 | -3 | -6 |
| [d:\GitRepos\JOGL-Engine\src\engine\ui\elements\Text.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cui%5Celements%5CText.java) | Java | -3 | 0 | -3 | -6 |
| [d:\GitRepos\JOGL-Engine\src\engine\ui\layouts\Grid.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cengine%5Cui%5Clayouts%5CGrid.java) | Java | -3 | 0 | -3 | -6 |
| [d:\GitRepos\JOGL-Engine\src\minesweeper\Constants.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cminesweeper%5CConstants.java) | Java | -17 | 0 | -7 | -24 |
| [d:\GitRepos\JOGL-Engine\src\minesweeper\Game.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cminesweeper%5CGame.java) | Java | -70 | -2 | -33 | -105 |
| [d:\GitRepos\JOGL-Engine\src\minesweeper\Main.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cminesweeper%5CMain.java) | Java | -9 | 0 | -5 | -14 |
| [d:\GitRepos\JOGL-Engine\src\minesweeper\gametypes\Tile.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cminesweeper%5Cgametypes%5CTile.java) | Java | -96 | -8 | -21 | -125 |
| [d:\GitRepos\JOGL-Engine\src\minesweeper\util\GameUtils.java](/d:%5CGitRepos%5CJOGL-Engine%5Csrc%5Cminesweeper%5Cutil%5CGameUtils.java) | Java | -17 | 0 | -10 | -27 |

[summary](results.md) / [details](details.md) / [diff summary](diff.md) / diff details