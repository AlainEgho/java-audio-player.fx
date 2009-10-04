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
