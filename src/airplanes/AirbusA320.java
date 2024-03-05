/**
 * @author Logan Taggart
 * @date 03-04-2024
 * @course CSCD 212
 */

package airplanes;

public class AirbusA320 extends Airplane {
    /**
     * The AirbusA320 Constructor makes a call to its parent constructor to make a new AirbusA320 object
     */
    public AirbusA320() {
        super(
                "Airbus A320",
                4, 10, 12,
                4, 6, 6
        );
    }
}