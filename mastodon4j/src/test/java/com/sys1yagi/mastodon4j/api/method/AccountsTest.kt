package com.sys1yagi.mastodon4j.api.method

import com.sys1yagi.mastodon4j.api.exception.Mastodon4jRequestException
import com.sys1yagi.mastodon4j.testtool.MockClient
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AccountsTest {
    @Test
    fun getAccount() {
        val client = MockClient.mock("account.json")
        val accounts = Accounts(client)
        val account = accounts.getAccount(1L).execute()
        account.acct shouldBeEqualTo "test@test.com"
        account.displayName shouldBeEqualTo "test"
        account.userName shouldBeEqualTo "test"
    }

    @Test
    fun getAccountWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.getAccount(1L).execute()
        }
    }

    @Test
    fun getVerifyCredentials() {
        val client = MockClient.mock("account.json")
        val accounts = Accounts(client)
        val account = accounts.getVerifyCredentials().execute()
        account.acct shouldBeEqualTo "test@test.com"
        account.displayName shouldBeEqualTo "test"
        account.userName shouldBeEqualTo "test"
    }

    @Test
    fun getVerifyCredentialsWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.getVerifyCredentials().execute()
        }
    }

    // TODO getVerifyCredentialsWith401

    @Test
    fun updateCredential() {
        val client = MockClient.mock("account.json")
        val accounts = Accounts(client)
        val account = accounts.updateCredential("test", "test", "test", "test").execute()
        account.acct shouldBeEqualTo "test@test.com"
        account.displayName shouldBeEqualTo "test"
        account.userName shouldBeEqualTo "test"
    }

    @Test
    fun updateCredentialWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.updateCredential("test", "test", "test", "test").execute()
        }
    }

    @Test
    fun getFollowers() {
        val client = MockClient.mock("accounts.json")
        val accounts = Accounts(client)
        val pageable = accounts.getFollowers(1L).execute()
        val account = pageable.part.first()
        account.acct shouldBeEqualTo "test@test.com"
        account.displayName shouldBeEqualTo "test"
        account.userName shouldBeEqualTo "test"
    }

    @Test
    fun getFollowersWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.getFollowers(1L).execute()
        }
    }

    @Test
    fun getFollowing() {
        val client = MockClient.mock("accounts.json")
        val accounts = Accounts(client)
        val pageable = accounts.getFollowing(1L).execute()
        val account = pageable.part.first()
        account.acct shouldBeEqualTo "test@test.com"
        account.displayName shouldBeEqualTo "test"
        account.userName shouldBeEqualTo "test"
    }

    @Test
    fun getFollowingWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.getFollowing(1L).execute()
        }
    }

    @Test
    fun getStatuses() {
        val client = MockClient.mock("statuses.json")
        val accounts = Accounts(client)
        val pageable = accounts.getStatuses(1, false).execute()
        val status = pageable.part.first()
        status.id shouldBeEqualTo 11111L
    }

    @Test
    fun getStatusesWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.getStatuses(1, false).execute()
        }
    }

    @Test
    fun postFollow() {
        val client = MockClient.mock("relationship.json")
        val accounts = Accounts(client)
        val relationship = accounts.postFollow(1L).execute()
        relationship.id shouldBeEqualTo 3361
        relationship.isFollowing shouldBeEqualTo true
        relationship.isFollowedBy shouldBeEqualTo false
        relationship.isBlocking shouldBeEqualTo false
        relationship.isMuting shouldBeEqualTo false
        relationship.isRequested shouldBeEqualTo false
    }

    @Test
    fun postFollowWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.postFollow(1L).execute()
        }
    }

    @Test
    fun postUnFollow() {
        val client = MockClient.mock("relationship.json")
        val accounts = Accounts(client)
        val relationship = accounts.postUnFollow(1L).execute()
        relationship.id shouldBeEqualTo 3361
        relationship.isFollowing shouldBeEqualTo true
        relationship.isFollowedBy shouldBeEqualTo false
        relationship.isBlocking shouldBeEqualTo false
        relationship.isMuting shouldBeEqualTo false
        relationship.isRequested shouldBeEqualTo false
    }

    @Test
    fun postUnFollowWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.postUnFollow(1L).execute()
        }
    }

    @Test
    fun postBlock() {
        val client = MockClient.mock("relationship.json")
        val accounts = Accounts(client)
        val relationship = accounts.postBlock(1L).execute()
        relationship.id shouldBeEqualTo 3361
        relationship.isFollowing shouldBeEqualTo true
        relationship.isFollowedBy shouldBeEqualTo false
        relationship.isBlocking shouldBeEqualTo false
        relationship.isMuting shouldBeEqualTo false
        relationship.isRequested shouldBeEqualTo false
    }

    @Test
    fun postBlockWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.postBlock(1L).execute()
        }
    }

    @Test
    fun postUnblock() {
        val client = MockClient.mock("relationship.json")
        val accounts = Accounts(client)
        val relationship = accounts.postUnblock(1L).execute()
        relationship.id shouldBeEqualTo 3361
        relationship.isFollowing shouldBeEqualTo true
        relationship.isFollowedBy shouldBeEqualTo false
        relationship.isBlocking shouldBeEqualTo false
        relationship.isMuting shouldBeEqualTo false
        relationship.isRequested shouldBeEqualTo false
    }

    @Test
    fun postUnblockWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.postUnblock(1L).execute()
        }
    }

    @Test
    fun postMute() {
        val client = MockClient.mock("relationship.json")
        val accounts = Accounts(client)
        val relationship = accounts.postMute(1L).execute()
        relationship.id shouldBeEqualTo 3361
        relationship.isFollowing shouldBeEqualTo true
        relationship.isFollowedBy shouldBeEqualTo false
        relationship.isBlocking shouldBeEqualTo false
        relationship.isMuting shouldBeEqualTo false
        relationship.isRequested shouldBeEqualTo false
    }

    @Test
    fun postMuteWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.postMute(1L).execute()
        }
    }

    @Test
    fun postUnmute() {
        val client = MockClient.mock("relationship.json")
        val accounts = Accounts(client)
        val relationship = accounts.postUnmute(1L).execute()
        relationship.id shouldBeEqualTo 3361
        relationship.isFollowing shouldBeEqualTo true
        relationship.isFollowedBy shouldBeEqualTo false
        relationship.isBlocking shouldBeEqualTo false
        relationship.isMuting shouldBeEqualTo false
        relationship.isRequested shouldBeEqualTo false
    }

    @Test
    fun postUnmuteWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.postUnmute(1L).execute()
        }
    }

    @Test
    fun getRelationships() {
        val client = MockClient.mock("relationships.json")
        val accounts = Accounts(client)
        val relationships = accounts.getRelationships(listOf(1L)).execute()
        val relationship = relationships.first()
        relationship.id shouldBeEqualTo 3361
        relationship.isFollowing shouldBeEqualTo true
        relationship.isFollowedBy shouldBeEqualTo false
        relationship.isBlocking shouldBeEqualTo false
        relationship.isMuting shouldBeEqualTo false
        relationship.isRequested shouldBeEqualTo false
    }

    @Test
    fun getRelationshipsWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.getRelationships(listOf(1L)).execute()
        }
    }

    @Test
    fun getAccountSearch() {
        val client = MockClient.mock("account_search.json")
        val accounts = Accounts(client)
        val result = accounts.getAccountSearch("test").execute()
        val account = result.first()
        account.acct shouldBeEqualTo "A"
        account.displayName shouldBeEqualTo ""
        account.userName shouldBeEqualTo "A"
    }

    @Test
    fun getAccountSearchWithException() {
        Assertions.assertThrows(Mastodon4jRequestException::class.java) {
            val client = MockClient.ioException()
            val accounts = Accounts(client)
            accounts.getAccountSearch("test").execute()
        }
    }
}
