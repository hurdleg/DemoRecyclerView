package mad9132.demorecyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;

// TODO #5 - create Java package named: model
// TODO #6 - add POJO class
/**
 * POJO class for a Course JSON object.
 *
 * A Course object has the following properties (in alphabetical order):
 *
 *   courseId    - (int) uniquely identify this course
 *   code        - (String) course code
 *   description - (String) course description
 *   level       - (int) course level
 *   name        - (String) course name
 *
 * Example:
 *   courseId    = 1
 *   code        = MAD932
 *   description = Let's learn native Android app development with Java.
 *   level       = 3
 *   name        = Android Application Development
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 */
public class CoursePOJO implements Parcelable {

    private int    courseId;
    private String code;
    private String description;
    private int    level;
    private String name;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.courseId);
        dest.writeString(this.code);
        dest.writeString(this.description);
        dest.writeInt(this.level);
        dest.writeString(this.name);
    }

    public CoursePOJO() {
    }

    protected CoursePOJO(Parcel in) {
        this.courseId = in.readInt();
        this.code = in.readString();
        this.description = in.readString();
        this.level = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<CoursePOJO> CREATOR = new Creator<CoursePOJO>() {
        @Override
        public CoursePOJO createFromParcel(Parcel source) {
            return new CoursePOJO(source);
        }

        @Override
        public CoursePOJO[] newArray(int size) {
            return new CoursePOJO[size];
        }
    };
}
