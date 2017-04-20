package by.epam.parsing.entity;

public enum TextDataType {
    TEXT(4), PARAGRAPH(3), SENTENCE(2),
    TOKEN(1), SYMBOL(0);

    private int id;

    TextDataType(int id){
        this.setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
