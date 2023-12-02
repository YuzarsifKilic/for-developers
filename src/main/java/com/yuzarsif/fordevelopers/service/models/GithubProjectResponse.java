package com.yuzarsif.fordevelopers.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class GithubProjectResponse {

    public int id;
    public String nodeId;
    public String name;
    public String fullName;
    @JsonProperty("private")
    public boolean myPrivate;
    public Owner owner;
    public String htmlUrl;
    public Object description;
    public boolean fork;
    public String url;
    public String forksUrl;
    public String keysUrl;
    public String collaboratorsUrl;
    public String teamsUrl;
    public String hooksUrl;
    public String issueEventsUrl;
    public String eventsUrl;
    public String assigneesUrl;
    public String branchesUrl;
    public String tagsUrl;
    public String blobsUrl;
    public String gitTagsUrl;
    public String gitRefsUrl;
    public String treesUrl;
    public String statusesUrl;
    public String languagesUrl;
    public String stargazersUrl;
    public String contributorsUrl;
    public String subscribersUrl;
    public String subscriptionUrl;
    public String commitsUrl;
    public String gitCommitsUrl;
    public String commentsUrl;
    public String issueCommentUrl;
    public String contentsUrl;
    public String compareUrl;
    public String mergesUrl;
    public String archiveUrl;
    public String downloadsUrl;
    public String issuesUrl;
    public String pullsUrl;
    public String milestonesUrl;
    public String notificationsUrl;
    public String labelsUrl;
    public String releasesUrl;
    public String deploymentsUrl;
    public Date createdAt;
    public Date updatedAt;
    public Date pushedAt;
    public String gitUrl;
    public String sshUrl;
    public String cloneUrl;
    public String svnUrl;
    public Object homepage;
    public int size;
    public int stargazersCount;
    public int watchersCount;
    public String language;
    public boolean hasIssues;
    public boolean hasProjects;
    public boolean hasDownloads;
    public boolean hasWiki;
    public boolean hasPages;
    public boolean hasDiscussions;
    public int forksCount;
    public Object mirrorUrl;
    public boolean archived;
    public boolean disabled;
    public int openIssues_Count;
    public Object license;
    public boolean allowForking;
    public boolean isTemplate;
    public boolean webCommitSignOfRequired;
    public ArrayList<Object> topics;
    public String visibility;
    public int forks;
    public int openIssues;
    public int watchers;
    public String defaultBranch;
    public Permissions permissions;
    public String tempCloneToken;
    public int networkCount;
    public int subscribersCount;

    public static class Owner{
        public String login;
        public int id;
        public String nodeId;
        public String avatarUrl;
        public String gravatarId;
        public String url;
        public String htmlUrl;
        public String followersUrl;
        public String followingUrl;
        public String gistsUrl;
        public String starredUrl;
        public String subscriptionsUrl;
        public String organizationsUrl;
        public String reposUrl;
        public String eventsUrl;
        public String receivedEventsUrl;
        public String type;
        public boolean siteAdmin;
    }

    public static class Permissions{
        public boolean admin;
        public boolean maintain;
        public boolean push;
        public boolean triage;
        public boolean pull;
    }
}




