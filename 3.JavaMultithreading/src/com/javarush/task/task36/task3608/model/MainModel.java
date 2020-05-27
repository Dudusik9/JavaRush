package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/*
Выполни рефакторинг класса MainModel. Теперь, когда есть удаленные пользователи, часть методов стала работать неправильно.
Почти во всех методах, где требуется список пользователей, нужно работать только с активными(живыми) пользователями.
Вынеси в отдельный приватный метод List<User> getAllUsers() получение списка всех активных пользователей.
Фильтрация активных пользователей у тебя уже есть - метод List<User> filterOnlyActiveUsers(List<User> allUsers).
Отрефактори все методы, которые используют список пользователей. Они должны использовать список живых пользователей.
 */
public class MainModel implements Model
{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    private List<User> getAllUsers()
    {
        List<User> list = userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
        return list;
    }

    @Override
    public ModelData getModelData()
        {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        List<User> list = new ArrayList<>(userService.getUsersBetweenLevels(1, 100));
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    @Override
     public void loadDeletedUsers()
     {
         List<User> users = userService.getAllDeletedUsers();
         modelData.setDisplayDeletedUserList(true);
         modelData.setUsers(users);
     }

     @Override
     public void loadUserById(long userId)
     {
         User user = userService.getUsersById(userId);
         modelData.setActiveUser(user);
     }


    public void deleteUserById(long id)
    {
        userService.deleteUser(id);
        loadUsers();
    }

    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name, id, level);
        loadUsers();
    }
}
