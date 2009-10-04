/**
 *
 * (c) Sergey Mashkov (aka cy6erGn0m), 2009
 *
 * License: GNU LGPL v3
 * To read license read lgpl-3.0.txt from root of repository or follow URL:
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 */
package cy6erGn0m.player.fx;

import com.sun.javafx.functions.Function0;
import maryb.player.Player;
import maryb.player.PlayerEventListener;
import javafx.lang.FX;

/**
 *
 * @author cy6ergn0m
 */
/* package */ class PlayerWrapper implements PlayerEventListener {

    private final Function0<Void> updater = new Function0<Void>() {

        @Override
        public Void invoke() {
            parent.setState( player.getState() );
            parent.setCurrentPosition( player.getCurrentPosition() );
            parent.setBufferedPosition( player.getCurrentBufferedTimeMcsec() );
            parent.setTotalPosition( player.getTotalPlayTimeMcsec() );

            player.setCurrentVolume( (float) parent.getVolume() );
            return null;
        }

    };

    private final Function0<Void> endOfMediaCall = new Function0<Void>() {

        @Override
        public Void invoke() {
            System.out.println( "eom in function0" );
            parent.endOfMediaReached();

            return null;
        }

    };

    private final PlayerModelIface parent;

    private final Player player = new Player();

    public PlayerWrapper( PlayerModelIface parent ) {
        this.parent = parent;
        player.setListener( this );

        stateChanged();
    }

    public void setLocation( String location ) {
        player.setSourceLocation( location );
    }

    public void setVolume( double volume ) {
        player.setCurrentVolume( (float) volume );
    }

    public void play() {
        player.play();
    }

    public void stop() {
        player.stop();
    }

    public void pause() {
        player.pause();
    }

    public void seek(long newPosMcsec ) {
        player.seek( newPosMcsec );
    }

    @Override
    public void endOfMedia() {
        FX.deferAction( endOfMediaCall );
    }

    @Override
    public void stateChanged() {
        FX.deferAction( updater );
    }

    @Override
    public void buffer() {
    }

}
