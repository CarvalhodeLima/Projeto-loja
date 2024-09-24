package entidades;
public class Loja{
   private String nomeLoja;
   private String linkLoja;
   private int sacLoja;
   private String emailLoja;
   private String descricaoLoja;
   
    public Loja(String nomeLoja, String linkLoja, int sacLoja, String emailLoja, String descricaoLoja) {
        this.nomeLoja = nomeLoja;
        this.linkLoja = linkLoja;
        this.sacLoja = sacLoja;
        this.emailLoja = emailLoja;
        this.descricaoLoja = descricaoLoja;
    }

    // Métodos getters e setters para os atributos da loja

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getLinkLoja() {
        return linkLoja;
    }

    public void setLinkLoja(String linkLoja) {
        this.linkLoja = linkLoja;
    }

    public int getSacLoja() {
        return sacLoja;
    }

    public void setSacLoja(int sacLoja) {
        this.sacLoja = sacLoja;
    }

    public String getEmailLoja() {
        return emailLoja;
    }

    public void setEmailLoja(String emailLoja) {
        this.emailLoja = emailLoja;
    }

    public String getDescricaoLoja() {
        return descricaoLoja;
    }

    public void setDescricaoLoja(String descricaoLoja) {
        this.descricaoLoja = descricaoLoja;
    }
}