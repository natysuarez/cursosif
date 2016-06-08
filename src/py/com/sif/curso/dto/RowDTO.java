package py.com.sif.curso.dto;

public class RowDTO {
    private VarietyDTO variety = null;
    private Integer seedsPerCell = null;
    
    
    
    
    public RowDTO() {
        super();
    }


    public VarietyDTO getVariety() {
        return this.variety;
    }


    public void setVariety(final VarietyDTO variety) {
        this.variety = variety;
    }

    public Integer getSeedsPerCell() {
        return this.seedsPerCell;
    }

    public void setSeedsPerCell(final Integer seedsPerCell) {
        this.seedsPerCell = seedsPerCell;
    }


    @Override
    public String toString() {
        return "Row [variety=" + this.variety + ", seedsPerCell=" + this.seedsPerCell + "]";
    }

}
