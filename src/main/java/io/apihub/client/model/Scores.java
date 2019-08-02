

package io.apihub.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


import io.apihub.client.model.Score;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.apihub.codegen.languages.JavaClientCodegen", date = "2019-08-01T16:44:21.339Z")
public class Scores {
  @SerializedName("scores")
  private List<Score> scores = null;
  public Scores scores(List<Score> scores) {
    this.scores = scores;
    return this;
  }
  public Scores addScoresItem(Score scoresItem) {
    if (this.scores == null) {
      this.scores = new ArrayList<Score>();
    }
    this.scores.add(scoresItem);
    return this;
  }
   
  public List<Score> getScores() {
    return scores;
  }
  public void setScores(List<Score> scores) {
    this.scores = scores;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scores scores = (Scores) o;
    return Objects.equals(this.scores, scores.scores);
  }
  @Override
  public int hashCode() {
    return Objects.hash(scores);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scores {\n");
    
    sb.append("    scores: ").append(toIndentedString(scores)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
