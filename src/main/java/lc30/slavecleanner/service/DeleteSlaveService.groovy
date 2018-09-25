package lc30.slavecleanner.service

import jenkins.model.Jenkins

import java.util.regex.Pattern

class DeleteSlaveService {

    def String[] deleteBySlavePatern(Pattern pattern) {
        def jenkins = Jenkins.instance
        def computers = jenkins.computers
        def unusedComputer = []

        computers.each {
            if (it.displayName.matches(pattern) && it.isOffline()) {
                unusedComputer.add(it.displayName)
            }
        }
        unusedComputer
    }
}
