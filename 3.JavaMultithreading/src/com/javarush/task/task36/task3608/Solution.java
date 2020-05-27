package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        //1 Показать всех пользователей
        usersView.fireEventShowAllUsers();
        //2 Взять пользователя на редактирование
        EditUserView editUserView = new EditUserView();
        controller.setEditUserView(editUserView);
        usersView.fireEventOpenUserEditForm(126);
        //3 Удалить пользователя
        editUserView.setController(controller);
        editUserView.fireEventUserDeleted(124L);
        //4 Изменить пользователя
        editUserView.fireEventUserChanged("Dudukin",123L, 50);
        //5 Вывести список удаленных пользователей
        usersView.fireEventShowDeletedUsers();
    }
}