package com.example.playwithroom.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Insert;

import com.example.playwithroom.model.PlayKidding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PlayGameOperations {

    Context context;
    DatabaseConnection connection;

    public PlayGameOperations(Context context) {
        this.context = context;
        connection = DatabaseConnection.getInstance(context);
    }

    public void insertPlayKidding(PlayKidding game) {

        new InsertGameTask().execute(game);
    }

    public List<PlayKidding> getAllGames() {

        List<PlayKidding> playKiddingList = new ArrayList<>();

        try {
            playKiddingList = new GetAllGamesTask().execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return playKiddingList;

    }

    public void deleteLastItem(PlayKidding game) {

        new DeleteLastTask().execute(game);

    }


    public class InsertGameTask extends AsyncTask<PlayKidding, Void, Void> {

        @Override
        protected Void doInBackground(PlayKidding... playKiddings) {
            connection.playKiddindDao().insert(playKiddings[0]);
            return null;
        }
    }

    public class GetAllGamesTask extends AsyncTask<Void, Void, List<PlayKidding>> {

        /*List<PlayKidding> playKiddingsList;

        public GetAllGamesTask(List<PlayKidding> playKiddings){
            this.playKiddingsList = playKiddings;
        }*/

        @Override
        protected List<PlayKidding> doInBackground(Void... voids) {
            return connection.playKiddindDao().getAllGames();
        }

       /* @Override
        protected void onPostExecute(List<PlayKidding> playKiddings) {
            super.onPostExecute(playKiddings);
            playKiddingsList.addAll(playKiddings);
        }*/
    }

    public class DeleteLastTask extends AsyncTask<PlayKidding, Void, Void> {


        @Override
        protected Void doInBackground(PlayKidding... playKiddings) {
            connection.playKiddindDao().deleteLastElement(playKiddings[0]);
            return null;
        }
    }
}
