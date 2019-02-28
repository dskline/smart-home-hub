package host.exp.exponent.feature.meetup;

import android.content.Context;

import java.util.List;

import host.exp.exponent.feature.meetup.model.MeetupResult;
import host.exp.exponent.feature.meetup.task.FindCompatibleMeetups;
import host.exp.exponent.feature.meetup.task.QueryMeetups;
import host.exp.exponent.feature.meetup.task.SendMeetupNotifications;

public class FindMeetupsAction {

    public void start(Context context) {
        new QueryMeetups().run((meetupList, forecastItemList) -> {
            List<MeetupResult> results = FindCompatibleMeetups.find(meetupList, forecastItemList);

            SendMeetupNotifications.send(context, results);
        });
    }
}
