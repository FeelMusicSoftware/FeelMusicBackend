package feelmusicbackend.demo.entity;

public class Language {
    private Integer languageId;
    private String language;

    public Language(){

    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", language='" + language + '\'' +
                '}';
    }
}
