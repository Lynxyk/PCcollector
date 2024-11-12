package ChoiceComponents;

/**
 * Класс отвечающий за хранение определенных характеристик
 */

public class ComponentChoice <Model> {
    /** поле price - цена */
    private int price;
    /** поле model - тип комплектующего*/
    private Model model;
    /** поле newIndex - индекс нового комплектующего из иерархии*/
    private int newIndex;
    /** mark - производитель комплектующего*/
    private String mark;
    /** modelComponent - модель комплектующего */
    private String modelComponent;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param model - тип
     * @param  price - цена
     */

    public ComponentChoice(Model model, int price) {
        this.price = price;
        this.model = model;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param model - тип
     * @param  price - цена
     * @param newIndex - индекс
     */

    public ComponentChoice(Model model, int price, int newIndex) {
        this.price = price;
        this.model = model;
        this.newIndex = newIndex;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param model - тип
     * @param  price - цена
     * @param mark - производитель
     * @param modelComponent - модель
     */

    public ComponentChoice(int price, Model model, String mark, String modelComponent) {
        this.price = price;
        this.model = model;
        this.mark = mark;
        this.modelComponent = modelComponent;
    }

    public int getPrice() {
        return price;
    }

    public Model getModel() {
        return model;
    }

    public String getMark() {
        return mark;
    }

    public String getModelComponent() {
        return modelComponent;
    }

    public int getNewIndex() {
        return newIndex;
    }
}
