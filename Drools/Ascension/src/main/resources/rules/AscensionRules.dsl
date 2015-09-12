[when] The case tags match the support engineer's tags=$supportcase : SupportCase() and $supportguy : SupportGuy ( Collections.disjoint(tags, $supportcase.tags) == false )
[when] The case geo match the support engineer's geo=$supportcase : SupportCase() and $supportguy : SupportGuy ( geo == $supportcase.geo )
[when] The case sbr matches the support engineer's sbr=$supportcase : SupportCase() and $supportguy : SupportGuy ( Collections.disjoint(sbrs, $supportcase.sbrs) == false )
[when] Prioritize customer {custName}=$supportcase : SupportCase(accountName == {custName}) 



[then] increment score by one= Integer theKey = new Integer($supportcase.getCaseId()); String theKeyString = theKey.toString(); Integer currentValue = (Integer)caseScores.get(theKeyString); Integer nextValue = new Integer(currentValue.intValue() + 1); caseScores.put(theKeyString, nextValue); 
[then] increment score by two= Integer theKey = new Integer($supportcase.getCaseId()); String theKeyString = theKey.toString(); Integer currentValue = (Integer)caseScores.get(theKeyString); Integer nextValue = new Integer(currentValue.intValue() + 2); caseScores.put(theKeyString, nextValue);
[then] increment score by five= Integer theKey = new Integer($supportcase.getCaseId()); String theKeyString = theKey.toString(); Integer currentValue = (Integer)caseScores.get(theKeyString); Integer nextValue = new Integer(currentValue.intValue() + 5); caseScores.put(theKeyString, nextValue);