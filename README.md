# quarkus-hexarch-statestore-service-archetype

## Create an archetype from scratch

```bash
mvn archetype:generate -B  \ 
-DarchetypeGroupId=org.apache.maven.archetypes  \
-DarchetypeArtifactId=maven-archetype-archetype  \
-DgroupId=com.telefonica.hispam.archetype  \
-DartifactId=example-archetype
```

## Create an archetype from a specific project

You need run the following command in your base project:

```bash
mvn archetype:create-from-project
```

## Install an archetype

You need run the following command in your base project:

```bash
mvn install
```

## Generate a project from an archetype

Step 1: Clone the repository

Step 2:  Run the following command,

```bash
mvn install
```

Step 3: Run the following command,

```bash
mvn archetype:generate -DarchetypeGroupId=com.telefonica.hispam.archetype  \
-DarchetypeArtifactId=quarkus-hexarch-statestore-service-archetype  \
-DarchetypeVersion=1.0-SNAPSHOT  \
-DgroupId=com.telefonica.hispam.example  \
-DartifactId=other-statestore-service \
-Dversion=1.0-SNAPSHOT
```