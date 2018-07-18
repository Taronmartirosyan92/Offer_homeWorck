package com.example.armen.offer.provider;


import com.example.armen.offer.R;
import com.example.armen.offer.models.MessageModel;
import com.example.armen.offer.models.UserModel;
import com.example.armen.offer.welcome.WelcomeModel;

import java.util.ArrayList;
import java.util.List;

public class AllProvider {
    public static List<WelcomeModel> getListWelcome() {
        final List<WelcomeModel> list = new ArrayList<>();
        WelcomeModel page1 = new WelcomeModel("Offer");
        WelcomeModel page2 = new WelcomeModel("Welcome to Offer", R.color.page_background);
        WelcomeModel page3 = new WelcomeModel("We change lives", R.color.page_background);
        list.add(page1);
        list.add(page2);
        list.add(page3);

        return list;
    }

    private static List<UserModel> myUserList = new ArrayList<>();
    public static List<UserModel> getListUsers() {
        if (!myUserList.isEmpty()) {
            myUserList.clear();
        }
        myUserList.add(new UserModel("Saqo", "barev!!", "https://www.instituteofhypnotherapy.com/wp-content/uploads/2016/01/tutor-8.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Vazgen", "barev", "http://www.sbeinc.com/files/layout/sbeinc/siteContent/editor/cook_hero.png", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Karen", "", "https://www.humanrights.gov.au/sites/default/files/styles/large/public/news/image/TimWilson20160215_0.jpg?itok=jUa84LIC", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Exish", "barev", "http://images.pushsquare.com/news/2018/05/guide_detroit_become_human_-_all_voice_actors/attachment/1/original.jpg", "", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Mono", "barev", "https://d1o50x50snmhul.cloudfront.net/wp-content/uploads/2018/03/29165725/ab77k935-800x533.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Flora", "barev", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7YZs82l8rZlOf-QjpaDol_QIftbrVFn4NGlaHw-uWDibT5qEw", "Developer ", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Sona", "barev", "https://vgtimes.ru/uploads/posts/2018-04/detroit-become-human-poluchit-drugoy-boks-art-v-yaponii-46848.jpg?1522852093", "Developer ", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Yonjo", "balus", "http://images.faena.com/wp-content/uploads/sites/4/2017/06/human-by-yann-arthus-bertrand3.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Poncho", "balus", "https://is1-ssl.mzstatic.com/image/thumb/Purple118/v4/16/8a/68/168a6877-42a3-e9f7-ba60-877fa11e2025/AppIcon-1x_U007emarketing-P3-85-220-5.png/246x0w.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Sencho", "balus", "https://i.amz.mshcdn.com/BF65pxWeaJ5BKCZ2QlOHvTp-iOU=/950x534/filters:quality(90)/https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com%2Fuploads%2Fcard%2Fimage%2F606054%2Ff5ce8db1-3094-48d4-a9c7-4c9364125ec0.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Exo", "balus", "https://sslb.ulximg.com/image/405x405/artist/1260292100_192289b014f160375ce906cb7ae14443.jpg/09c9d1b764211ca25bbd7469faae95a2/1260292100_2pac.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Karapet", "balus", "https://pbs.twimg.com/profile_images/752736773181026304/0H5JGhPb.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        myUserList.add(new UserModel("Varpet", "balus", "https://eastern.in/wp-content/uploads/2016/09/software-developer-copy-1024x1024-1.jpg", "Developer", "055888888", "saqo@mail.ru", "Marital status-none", "age -26", new ArrayList<MessageModel>()));
        return myUserList;
    }

    public static UserModel getUserPosition(int position) {
        return myUserList.get(position);
    }
}
