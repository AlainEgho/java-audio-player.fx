/*
 * Main.fx
 *
 * Created on 28.09.2009, 1:27:16
 */

package javafxapplication1;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafxapplication1.TestItNow;
import cy6erGn0m.player.fx.Player;
import javafx.scene.control.TextBox;
import javafx.scene.control.Slider;

/**
 * @author cy6ergn0m
 */

var tb : TextBox;
var src : String = bind tb.rawText;

def player : Player = Player{
    location: bind src
};

Stage {
    title: "Application title"
    width: 280
    height: 180
    scene: Scene {
        content: [
            Text {
                font : Font {
                    size : 16
                }
                x: 10
                y: 90
                content: bind "v: {player.state}"
            }
            tb = TextBox {
                width: 150
            }
            Button {
                translateY: 50
                action: function() {
                    player.play();
                }
                text: "Play"
            }
            Button {
                translateY: 50
                translateX: 70
                text: "Stop"

                action: function() {
                    player.stop();
                }

            }
            Slider {
                translateY: 50
                translateX: 150
                width: 100
                value: bind player.volume with inverse
                min: 0
                max: 1.
            }

        ]
    }
};