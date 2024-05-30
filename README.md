# quarkus-hexarch-statestore-service-archetype

## Generate a service from archetype

Step 1: Clone the repository

Step 2: mvn install

Step 3: Run the following command,

mvn archetype:generate -DarchetypeGroupId=com.telefonica.hispam.archetype  \
-DarchetypeArtifactId=quarkus-hexarch-statestore-service-archetype  \
-DarchetypeVersion=1.0-SNAPSHOT  \
-DgroupId=com.telefonica.hispam.example  \
-DartifactId=other-statestore-service \
-Dversion=1.0-SNAPSHOT
