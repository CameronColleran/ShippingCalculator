/**
 * (Model) Class which represents a shipping item and all its corresponding data
 *
 * @author Cameron Colleran
 */
package cs134.miracosta.edu.Model;

public class ShipItem
{
    /**
     * Instance variables
     */

    /** The weight of the item */
    private double weight;
    /** The base cost of the item */
    private double baseCost;
    /** The added cost of the item */
    private double addedCost;
    /** The total cost of the item (base + added) */
    private double totalCost;

    /**
     * Constructor for ShipItem. Creates new object and sets all variables to 0, except base cost
     * which is set to 3
     */
    public ShipItem()
    {
        weight = 0.0;
        baseCost = 3.0;
        addedCost = 0.0;
        totalCost = 0.0;
    }

    /**
     * Getter for item's weight
     *
     * @return item's weight
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Getter for item's base cost
     *
     * @return item's base cost
     */
    public double getBaseCost()
    {
        return baseCost;
    }

    /**
     * Getter for item's added cost
     *
     * @return item's added cost
     */
    public double getAddedCost()
    {
        return addedCost;
    }

    /**
     * Getter for item's total cost
     *
     * @return item's total cost
     */
    public double getTotalCost()
    {
        return totalCost;
    }

    /**
     * Setter for item's weight.
     * Calculates added cost, then total cost by adding added and base costs
     *
     * @param weight the weight which the item will be set to
     */
    public void setWeight(double weight)
    {
        this.weight = weight;

        // If else which checks the weight of the item: if item > 16, then subtract 16 from it,
        // divide by 4, then multiply by 0.5 and this is the added cost.
        if (weight <= 16)
        {
            addedCost = 0.0;
        }
        else
        {
            double difference = weight - 16;
            double quotientRoundUp = Math.ceil(difference / 4);
            addedCost = quotientRoundUp * 0.5;
        }

        totalCost = baseCost + addedCost;
    }
}
