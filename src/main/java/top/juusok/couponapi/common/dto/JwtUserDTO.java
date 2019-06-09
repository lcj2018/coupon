package top.juusok.couponapi.common.dto;

public class JwtUserDTO {
	
    private String id;

    public JwtUserDTO(String id) {
        this.id = id;
    }

    public JwtUserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
