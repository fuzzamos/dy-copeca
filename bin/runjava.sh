echo sanghu
i=1;
for file in ~/workspace/NEW_COPECA/src/With_DC_truthTable_fileGeneration****.java; do 
javac With_DC_truthTable_fileGeneration$i.java;
java With_DC_truthTable_fileGeneration$i;
((i=i+1)); 
done
