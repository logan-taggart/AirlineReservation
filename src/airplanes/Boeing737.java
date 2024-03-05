/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airplanes;

public class Boeing737 extends Airplane {
    /**
     * The Boeing737 Constructor makes a call to its parent constructor to make a new Boeing737 object
     */
    public Boeing737() {
        super("Boeing 737",
                3, 7, 15,
                6, 9,9
        );
    }
}