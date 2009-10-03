package cy6erGn0m.player.fx;

import maryb.player.PlayerState;

/**
 *
 * @author cy6ergn0m
 */
/* package */ interface PlayerModelIface {

    void setCurrentPosition( long timeMcsec );

    void setBufferedPosition( long timeMcsec );

    void setTotalPosition( long timeMcsec );

    void setState( PlayerState state );

    double getVolume();

    void endOfMediaReached();

}
