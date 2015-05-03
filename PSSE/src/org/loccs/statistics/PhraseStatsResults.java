package org.loccs.statistics;


public class PhraseStatsResults {
    private int phraseLength;

    private int totalDocumentCount;

    private int phraseCount = 0;

    private int[] phraseDetailCount;

    public PhraseStatsResults(int phraseLength, int totalDocumentCount) {
//begin of modifiable zone(JavaSuper).....C/787f7f76-7db8-4803-9dfb-ca6082590cbc

//end of modifiable zone(JavaSuper).......E/787f7f76-7db8-4803-9dfb-ca6082590cbc
//begin of modifiable zone................T/46623728-cf8a-4022-b4af-844007b1d648
        this.phraseLength = phraseLength;
        this.totalDocumentCount = totalDocumentCount;
        phraseDetailCount = new int[totalDocumentCount];
//end of modifiable zone..................E/46623728-cf8a-4022-b4af-844007b1d648
    }

    int getPhraseLength() {
//begin of modifiable zone................T/1656982f-4ab8-4338-9f71-cac9ffe6ae40
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/1656982f-4ab8-4338-9f71-cac9ffe6ae40
//begin of modifiable zone................T/4ee0db05-3266-47d7-b1e1-7ca7a9f43e48
        return this.phraseLength;
//end of modifiable zone..................E/4ee0db05-3266-47d7-b1e1-7ca7a9f43e48
    }

    int getTotalDocumentCount() {
//begin of modifiable zone................T/ffa1aa82-a32d-4c34-af13-b04db404b196
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/ffa1aa82-a32d-4c34-af13-b04db404b196
//begin of modifiable zone................T/ac1b8c01-e2d3-4628-80d4-88203cd8f6ba
        return this.totalDocumentCount;
//end of modifiable zone..................E/ac1b8c01-e2d3-4628-80d4-88203cd8f6ba
    }

    int getPhraseCount() {
//begin of modifiable zone................T/c9386e7c-d3e9-4f8e-8800-0c4bd336f746
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/c9386e7c-d3e9-4f8e-8800-0c4bd336f746
//begin of modifiable zone................T/ef761df9-55f7-458e-96ed-0bac09b0cd34
        return this.phraseCount;
//end of modifiable zone..................E/ef761df9-55f7-458e-96ed-0bac09b0cd34
    }

    public void increaseDetailCount(int documentCount) {
//begin of modifiable zone................T/35a1710b-d379-4928-a605-f19dee5c6a3e
        phraseDetailCount[documentCount - 1]++;
        phraseCount++;
//end of modifiable zone..................E/35a1710b-d379-4928-a605-f19dee5c6a3e
    }

    int[] getPhraseDetailCount() {
//begin of modifiable zone................T/cdf750d2-1084-4db2-84a9-8a77e55ebb50
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/cdf750d2-1084-4db2-84a9-8a77e55ebb50
//begin of modifiable zone................T/54d7b809-54f9-4e3f-84e1-96018a79680d
        return this.phraseDetailCount;
//end of modifiable zone..................E/54d7b809-54f9-4e3f-84e1-96018a79680d
    }

}
