package org.prova.model;

public class Menu {

    private int idMenu;
    private String menuName;


    public Menu(int idMenu, String menuName) {
        this.idMenu = idMenu;
        this.menuName = menuName;
    }


    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
