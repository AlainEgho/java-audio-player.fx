package cy6erGn0m.player.fx;

import maryb.player.PlayerState;

/**
 * @author cy6ergn0m
 */

public class Player {
    def model : PlayerModel = PlayerModel { parent: this };
    def wrapper : PlayerWrapper = new PlayerWrapper(model);

    public-read var currentPosition : Duration;
    public-read var bufferedPosition : Duration;
    public-read var totalPosition : Duration;
    public-read var state : PlayerState;
    public var endOfMedia : function();

    public var volume : Number = 0.5 on replace {
        wrapper.setVolume(volume.doubleValue());
    }

    public var location : String = "" on replace {
        wrapper.setLocation(location);
    }

    public function play() : Void {
        wrapper.play();
    }

    public function stop() : Void {
        wrapper.stop();
    }

    public function pause() : Void {
        wrapper.pause();
    }

    public function seek( pos : Duration ) {
        wrapper.seek(pos.toMillis() * 1000.);
    }


}

class PlayerModel extends PlayerModelIface {
    public-init var parent : Player;

    function toDuration( time : Long ) : Duration {
        Duration.valueOf( time.doubleValue() / 1000. );
    }


    public override function setCurrentPosition( time : Long ) : Void {
        parent.currentPosition = toDuration( time );
    }

    
    public override function setBufferedPosition( time : Long ) : Void {
        parent.bufferedPosition = toDuration( time );
    }


    public override function setTotalPosition( time : Long ) : Void {
        parent.totalPosition = toDuration( time );
    }

    public override function setState( state : PlayerState ) : Void {
        parent.state = state;
    }

    public override function getVolume() : Double {
        parent.volume
    }

    public override function endOfMediaReached() : Void {
        parent.endOfMedia();
    }


}
